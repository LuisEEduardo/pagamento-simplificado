package com.desafio.picpay.entities;

public enum TypeUser {

    COMUM("comum"),
    LOJISTA("lojista");

    private String type;

    TypeUser(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
