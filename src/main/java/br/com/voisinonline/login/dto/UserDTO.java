package br.com.voisinonline.login.dto;

import lombok.*;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO implements Serializable {
    private static final long serialVersionUID = -4794957480784495742L;

    private String id;
    private String mail;
    private String name;
    private String phone;
    private boolean active;
}