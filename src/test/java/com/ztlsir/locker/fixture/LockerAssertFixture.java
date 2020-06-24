package com.ztlsir.locker.fixture;

import com.ztlsir.locker.Locker;
import com.ztlsir.locker.Pack;
import com.ztlsir.locker.Ticket;
import com.ztlsir.locker.exception.IllegalTicketException;
import com.ztlsir.locker.exception.LockerFullException;
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

    public static void assertTicketAndPackSavedLocker(Locker locker, Pack preSavePack, Ticket ticket) {
        assertTicketNotEmpty(ticket);
        Pack pack = locker.takePackage(ticket);
        assertEquals(preSavePack, pack);
    }

    public static void assertThrowLockerFullException(Executable executable) {
        assertThrowException(LockerFullException.class, executable, lockerFullErrorMessage);
    }

    public static void assertThrowIllegalTicketException(Executable executable) {
        assertThrowException(IllegalTicketException.class, executable, ilLegalTicketErrorMessage);
    }

    private static <T extends Throwable> void assertThrowException(
            Class<T> expectedType,
            Executable executable,
            String expectedErrorMessage) {
        T exception = assertThrows(
                expectedType,
                executable);
        assertEquals(expectedErrorMessage, exception.getMessage());
    }
}
