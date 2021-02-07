package br.com.voisinonline.login.enums;

public enum CryptoParamsEnum {

    BCRYPT("BCrypt", 10);

    private String name;
    private int cost;

    CryptoParamsEnum(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}