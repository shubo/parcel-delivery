package com.guavapay.orderms.exception;

public class InsufficientPrivilegesException extends RuntimeException{
    public InsufficientPrivilegesException(){
        super("This User Have Insufficient Privileges");
    }
}
