package com.ztlsir.fixture;

import com.ztlsir.BaseLockerRobot;
import com.ztlsir.Pack;
import com.ztlsir.Ticket;
import com.ztlsir.exception.LockerFullException;
import org.junit.jupiter.api.function.Executable;

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
        assertThrowLockerFullException(() -> lockerRobot.savePackage(preSavePack));
    }

    public static void assertThrowLockerFullException(Executable executable) {
        LockerFullException exception = assertThrows(
                LockerFullException.class,
                executable);
        assertEquals(lockerFullErrorMessage, exception.getMessage());
    }
}
