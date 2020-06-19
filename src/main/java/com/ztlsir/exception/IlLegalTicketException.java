package com.ztlsir.exception;

public class IlLegalTicketException extends RuntimeException {
    public IlLegalTicketException() {
        super("非法票据");
    }
}
