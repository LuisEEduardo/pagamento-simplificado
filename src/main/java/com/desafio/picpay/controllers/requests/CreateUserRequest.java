package com.desafio.picpay.controllers.requests;

import com.desafio.picpay.entities.TypeDocument;
import com.desafio.picpay.entities.TypeUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

public record CreateUserRequest(
        String name,
        String email,
        String password,
        BigDecimal balance,
        String document,
        TypeDocument typeDocument,
        TypeUser typeUser
) {}