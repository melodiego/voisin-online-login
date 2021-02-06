package br.com.voisinonline.login.model;

import lombok.*;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CryptoParams implements Serializable {
    private static final long serialVersionUID = 4434858121279750209L;

    private String type;
    private int cost;
    private String version;
}