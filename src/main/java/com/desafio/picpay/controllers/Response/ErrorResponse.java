package com.desafio.picpay.controllers.Response;

import java.time.LocalDateTime;

public record ErrorResponse(Boolean status, Object errors, LocalDateTime timestamp) {
}
