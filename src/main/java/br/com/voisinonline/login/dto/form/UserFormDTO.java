package br.com.voisinonline.login.dto.form;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFormDTO implements Serializable {
    private static final long serialVersionUID = -5427059725181642708L;

    private String id;
    @NotBlank(message = "The name could not be null or empty.")
    private String name;
    @NotBlank(message = "The mail could not be null or empty.")
    private String mail;
    @NotBlank(message = "The phone could not be null or empty.")
    private String phone;
    @NotNull(message = "The active could not be null or empty.")
    private boolean active;
}