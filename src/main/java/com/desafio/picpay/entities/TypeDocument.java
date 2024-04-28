package com.desafio.picpay.entities;

public enum TypeDocument {
    CPF("cpf"),
    CNPJ("cnpj");

    private String document;

    TypeDocument(String document) {
        this.document = document;
    }

    public String getDocument() {
        return document;
    }

}
