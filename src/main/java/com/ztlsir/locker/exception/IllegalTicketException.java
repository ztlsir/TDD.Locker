package com.ztlsir.locker.exception;

public class IllegalTicketException extends RuntimeException {
    public IllegalTicketException() {
        super("非法票据");
    }
}
