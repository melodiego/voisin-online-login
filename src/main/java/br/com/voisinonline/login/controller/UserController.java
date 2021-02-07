package br.com.voisinonline.login.controller;

import br.com.voisinonline.login.dto.UserDTO;
import br.com.voisinonline.login.dto.form.CredentialFormDTO;
import br.com.voisinonline.login.dto.form.UserFormDTO;
import br.com.voisinonline.login.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> get(@PathVariable(value = "id") @Valid String id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody @Valid UserFormDTO userFormDTO) {
        return new ResponseEntity<>(service.save(userFormDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable("id") String id, @RequestBody @Valid UserFormDTO userFormDTO) {
        return new ResponseEntity<>(service.update(id, userFormDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") String id) {
        service.delete(id);
    }

    @PostMapping(value = "/{id}/credential")
    public ResponseEntity<?> createCredential(@PathVariable("id") String id,
                                              @RequestBody @Valid CredentialFormDTO credentialFormDTO) {
        service.createCredential(id, credentialFormDTO);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping(value = "/{key}/credential")
    public ResponseEntity<?> updateCredential(@PathVariable("id") String id,
                                              @RequestBody @Valid CredentialFormDTO credentialFormDTO) {
        service.updateCredential(id, credentialFormDTO);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/credential")
    public ResponseEntity<?> disableCredential(@PathVariable("id") String id) {
        service.disableCredential(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}