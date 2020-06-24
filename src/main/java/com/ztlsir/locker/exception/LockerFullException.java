package com.ztlsir.locker.exception;

public class LockerFullException extends RuntimeException {
    public LockerFullException() {
        super("储物柜已满");
    }
}
