package com.ztlsir.exception;

public class LockerFullException extends RuntimeException {
    public LockerFullException() {
        super("储物柜已满");
    }
}
