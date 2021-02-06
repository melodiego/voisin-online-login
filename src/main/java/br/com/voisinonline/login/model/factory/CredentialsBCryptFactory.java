package br.com.voisinonline.login.model.factory;

import br.com.voisinonline.login.dto.form.CredentialFormDTO;
import br.com.voisinonline.login.enums.CryptoParamsEnum;
import br.com.voisinonline.login.model.Credential;
import br.com.voisinonline.login.model.CredentialPassword;
import br.com.voisinonline.login.model.CryptoParams;
import br.com.voisinonline.login.util.PasswordUtil;

import java.time.LocalDateTime;
import java.util.Objects;

public class CredentialsBCryptFactory {

    private CredentialsBCryptFactory() { throw new IllegalStateException("Utility class");}

    public static Credential create(String credentialName, CredentialFormDTO dto) {
        byte[] salt = PasswordUtil.generateSaltBcrypt();
        byte[] hashPass = PasswordUtil.hashBcrypt(dto.getPassword().getBytes(), salt);

        Credential credential = new Credential();
        credential.setName(credentialName);
        credential.setCreatedAt(LocalDateTime.now());

        CredentialPassword data = new CredentialPassword(hashPass, salt);
        credential.setData(data);
        credential.setActive(Boolean.TRUE);

        credential.setCryptoParams(getCryptoParams());

        return credential;
    }

    public static void update(Credential credential, CredentialFormDTO dto) {

        byte[] salt = PasswordUtil.generateSaltBcrypt();
        byte[] hashPass = PasswordUtil.hashBcrypt(dto.getPassword().getBytes(), salt);

        if(Objects.nonNull(credential.getData())){
            credential.getData().setSalt(salt);
            credential.getData().setValue(hashPass);
        }else{
            credential.setData(new CredentialPassword(hashPass, salt));
        }

        if(Objects.nonNull(credential.getCryptoParams())){
            credential.getCryptoParams().setType(CryptoParamsEnum.BCRYPT.getName());
            credential.getCryptoParams().setCost(CryptoParamsEnum.BCRYPT.getCost());
        }else{
            credential.setCryptoParams(getCryptoParams());
        }
        credential.setActive(true);
        credential.setUpdatedAt(LocalDateTime.now());
    }

    private static CryptoParams getCryptoParams(){
        return new CryptoParams(CryptoParamsEnum.BCRYPT.getName(), CryptoParamsEnum.BCRYPT.getCost(), "VERSION_2Y");
    }
}
