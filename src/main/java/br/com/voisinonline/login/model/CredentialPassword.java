package br.com.voisinonline.login.model;

import lombok.*;

import java.io.Serializable;


@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CredentialPassword implements Serializable {
    private static final long serialVersionUID = -7330807879801735018L;

    private byte[] value;
    private byte[] salt;
}