package com.guavapay.userms.exception;

public class ExistingEmailException extends RuntimeException {
    public ExistingEmailException(String msg) {
        super(msg);
    }
}
