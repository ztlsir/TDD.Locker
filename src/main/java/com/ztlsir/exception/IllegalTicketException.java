package com.ztlsir.exception;

public class IllegalTicketException extends RuntimeException {
    public IllegalTicketException() {
        super("非法票据");
    }
}
