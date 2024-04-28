package com.desafio.picpay.infra.exception;

import com.desafio.picpay.config.Zone;
import com.desafio.picpay.controllers.Response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleMethodNotFoundException(NotFoundException exception) {
        log.error("handleMethodNotFoundException => " + exception.getMessage());
        return new ErrorResponse(false, exception.getMessage(), LocalDateTime.now(ZoneId.of(Zone.BRASIL)));
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodBadRequestException(BadRequestException exception) {
        log.error("handleMethodBadRequestException => " + exception.getMessage());
        return new ErrorResponse(false, exception.getMessage(), LocalDateTime.now(ZoneId.of(Zone.BRASIL)));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodException(Exception exception) {
        log.error("handleMethodException => " + exception.getMessage());
        return new ErrorResponse(false, exception.getMessage(), LocalDateTime.now(ZoneId.of(Zone.BRASIL)));
    }
}
