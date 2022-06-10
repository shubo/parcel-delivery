package com.guavapay.userms.exception;

import com.guavapay.userms.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleUserNotFoundExp(UserNotFoundException exp) {
        return ErrorResponse.builder()
                .message(exp.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(InsufficientPrivilegesException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleInsufficientPrivilegesExp(InsufficientPrivilegesException exp) {
        return ErrorResponse.builder()
                .message(exp.getMessage())
                .status(HttpStatus.FORBIDDEN.value())
                .build();
    }
}
