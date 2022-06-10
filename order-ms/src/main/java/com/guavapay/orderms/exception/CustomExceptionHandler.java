package com.guavapay.orderms.exception;

import com.guavapay.orderms.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(InsufficientPrivilegesException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleInsufficientPrivilegesExp(InsufficientPrivilegesException exp) {
        return ErrorResponse.builder()
                .message(exp.getMessage())
                .status(HttpStatus.FORBIDDEN.value())
                .build();
    }

    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleOrderNotFoundExp(OrderNotFoundException exp) {
        return ErrorResponse.builder()
                .message(exp.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }
}
