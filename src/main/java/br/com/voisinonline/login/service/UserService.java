package br.com.voisinonline.login.service;

import br.com.voisinonline.login.dto.UserDTO;
import br.com.voisinonline.login.dto.form.CredentialFormDTO;
import br.com.voisinonline.login.dto.form.UserFormDTO;
import br.com.voisinonline.login.exception.BadRequestException;
import br.com.voisinonline.login.exception.DuplicatedIDException;
import br.com.voisinonline.login.exception.RecordNotFoundException;
import br.com.voisinonline.login.model.Credential;
import br.com.voisinonline.login.model.User;
import br.com.voisinonline.login.model.factory.CredentialsBCryptFactory;
import br.com.voisinonline.login.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    public static final String CANNOT_FIND_ANY_REGISTRY_WITH_THIS_ID = "Não é possível encontrar nenhum registro com este ID ";
    public static final String CANNOT_USE_EMAIL_EXISTS = "Não é possível utilizar este valor no campo email, por favor altere o valor e tente novamente.";
    public static final String ERROR_CREDENTIAL_NOT_EXISTS = "Não há credenciais registradas para ";

    private final UserRepository repository;
    private final ModelMapper mapper;

    public UserService(UserRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public UserDTO findById(String id) {
        return mapper.map(getUserById(id), UserDTO.class);
    }

    public UserDTO save(UserFormDTO userFormDTO) {
        if (repository.findByMail(userFormDTO.getMail()).isPresent()) {
            throw new DuplicatedIDException(CANNOT_USE_EMAIL_EXISTS);
        }
        return mapper.map(repository.save(mapper.map(userFormDTO, User.class)), UserDTO.class);
    }

    public UserDTO update(String id, UserFormDTO userFormDTO) {
        repository.findById(id).orElseThrow(() -> new RecordNotFoundException(CANNOT_FIND_ANY_REGISTRY_WITH_THIS_ID + id));
        if (!id.equals(userFormDTO.getId())) {
            throw new BadRequestException("O ID informado não corresponde ao objeto a ser alterado");
        }
        return mapper.map(repository.save(mapper.map(userFormDTO, User.class)), UserDTO.class);
    }

    public void delete(String id) {
        User user = repository.findById(id).orElseThrow(() -> new RecordNotFoundException(CANNOT_FIND_ANY_REGISTRY_WITH_THIS_ID + id));
        repository.delete(user);
    }

    public void createCredential(String id, CredentialFormDTO credentialFormDTO) {
        User user = getUserById(id);

        user.setCredential(CredentialsBCryptFactory.create(credentialFormDTO));
        user.setUpdatedAt(LocalDateTime.now());

        repository.save(user);
    }

    public void updateCredential(String key, CredentialFormDTO dto) {
        User user = getUserById(key);
        Credential credential = user.getCredential();
        CredentialsBCryptFactory.update(credential, dto);
        user.setCredential(credential);
        user.setActive(Boolean.TRUE);
        repository.save(user);
    }

    public void disableCredential(String id) {
        User user = getUserById(id);
        clearCredential(user.getCredential(), id);
        repository.save(user);
    }

    private void clearCredential(Credential credential, String id) {
        if (existsCredentials(credential)) {
            credential.setActive(Boolean.FALSE);
            credential.setData(null);
            credential.setCreatedAt(null);
            credential.setUpdatedAt(null);
            credential.setCryptoParams(null);
        } else {
            throw new RecordNotFoundException(ERROR_CREDENTIAL_NOT_EXISTS + id);
        }
    }

    private boolean existsCredentials(Credential credential) {
        return credential != null;
    }

    private User getUserById(String id) {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(CANNOT_FIND_ANY_REGISTRY_WITH_THIS_ID + id));
    }
}