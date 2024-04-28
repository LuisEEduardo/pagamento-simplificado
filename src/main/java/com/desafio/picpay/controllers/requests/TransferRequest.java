package com.desafio.picpay.controllers.requests;

import java.math.BigDecimal;

public record TransferRequest(Long payerUserId, Long payeeUserId, BigDecimal amount) {
}
