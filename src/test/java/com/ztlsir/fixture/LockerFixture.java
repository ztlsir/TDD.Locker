package com.ztlsir.fixture;

import com.ztlsir.Locker;
import com.ztlsir.Ticket;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LockerFixture {
    public static final String lockerFullErrorMessage = "储物柜已满";
    public static final String ilLegalTicketErrorMessage = "非法票据";

    public static void assertTicketNotEmpty(Ticket ticket) {
        assertNotNull(ticket);
        assertNotNull(ticket.getSerialNo());
        assertNotEquals("", ticket.getSerialNo());
    }

    public static Locker createAvailableLocker() {
        return new Locker(10);
    }

    public static Locker createFullLocker() {
        return new Locker(0);
    }
}
