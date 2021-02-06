package br.com.voisinonline.login.model;

import br.com.voisinonline.login.enums.CredentialTypeEnum;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credential implements Serializable {
    private static final long serialVersionUID = 715622474591121758L;

    private String name;
    private boolean active;
    private CredentialTypeEnum type = CredentialTypeEnum.PASSWORD;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
    private LocalDateTime lastLogin;
    private LocalDateTime lastLoginInvalid;
    private CryptoParams cryptoParams;
    private CredentialPassword data;
}
