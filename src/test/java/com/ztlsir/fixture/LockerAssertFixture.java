package com.ztlsir.fixture;

import com.ztlsir.BaseLockerRobot;
import com.ztlsir.Pack;
import com.ztlsir.Ticket;
import com.ztlsir.exception.LockerFullException;

import static org.junit.jupiter.api.Assertions.*;

public class LockerAssertFixture {
    public static final String lockerFullErrorMessage = "储物柜已满";
    public static final String ilLegalTicketErrorMessage = "非法票据";

    public static void assertTicketNotEmpty(Ticket ticket) {
        assertNotNull(ticket);
        assertNotNull(ticket.getSerialNo());
        assertNotEquals("", ticket.getSerialNo());
    }

    public static void assertThrowLockerFullException(BaseLockerRobot lockerRobot, Pack preSavePack) {
        LockerFullException exception = assertThrows(
                LockerFullException.class,
                () -> lockerRobot.savePackage(preSavePack));
        assertEquals(lockerFullErrorMessage, exception.getMessage());
    }
}
