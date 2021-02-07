package br.com.voisinonline.login.dto.form;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationFormDTO implements Serializable {
    private static final long serialVersionUID = -8941803140864565748L;

    @NotBlank(message = "The userId  could not be null or empty.")
    private String id;
    @NotBlank(message = "The password could not be null or empty.")
    private String password;
}