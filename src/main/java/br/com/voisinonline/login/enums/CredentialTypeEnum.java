package br.com.voisinonline.login.enums;

import lombok.Getter;

@Getter
public enum CredentialTypeEnum {

    PASSWORD(1, "PASSWORD");

    private Integer id;
    private String name;

    private CredentialTypeEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}