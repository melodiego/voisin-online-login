package br.com.voisinonline.login.dto;

import br.com.voisinonline.login.enums.CredentialTypeEnum;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CredentialDTO implements Serializable {
    private static final long serialVersionUID = 39521762347285315L;

    private String name;
    private boolean active;
    private CredentialTypeEnum type;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLogin;
    private LocalDateTime lastLoginInvalid;
    private CredentialPasswordDTO data;
}
