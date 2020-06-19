package com.ztlsir.fixture;

import com.ztlsir.Ticket;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LockerFixture {
    public static void assertTicketNotEmpty(Ticket ticket) {
        assertNotNull(ticket);
        assertNotNull(ticket.getSerialNo());
        assertNotEquals("", ticket.getSerialNo());
    }
}
