package br.com.voisinonline.login.dto;

import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CredentialPasswordDTO {

    private String value;
    private String salt;
}