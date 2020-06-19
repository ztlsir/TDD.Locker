package com.ztlsir;

public class IlLegalTicketException extends RuntimeException {
    public IlLegalTicketException() {
        super("非法票据");
    }
}
