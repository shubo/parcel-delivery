package com.guavapay.orderms.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException() {
        super("Order Not Found");
    }
}
