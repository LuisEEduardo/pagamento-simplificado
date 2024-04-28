package com.desafio.picpay.controllers.Response;

import com.desafio.picpay.entities.TypeDocument;
import com.desafio.picpay.entities.TypeUser;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Boolean active,
        String name,
        String email,
        String password,
        BigDecimal balance,
        String document,
        TypeDocument typeDocument,
        TypeUser typeUser
) {}