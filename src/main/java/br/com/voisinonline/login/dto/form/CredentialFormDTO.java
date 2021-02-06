package br.com.voisinonline.login.dto.form;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CredentialFormDTO implements Serializable {

    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$", message = "The password not match with the complexity")
    @NotBlank(message = "The password could not be null or empty.")
    private String password;
    private String mail;
}