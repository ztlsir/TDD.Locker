package com.ztlsir.fixture;

import com.ztlsir.BaseLockerRobot;
import com.ztlsir.Pack;
import com.ztlsir.Ticket;

import static com.ztlsir.fixture.LockerAssertFixture.assertThrowIllegalTicketException;
import static com.ztlsir.fixture.LockerAssertFixture.assertThrowLockerFullException;

public class LockerRobotAssertFixture {
    public static void assertThrowLockerFullExceptionWhileSavePackage(BaseLockerRobot lockerRobot, Pack preSavePack) {
        assertThrowLockerFullException(() -> lockerRobot.savePackage(preSavePack));
    }

    public static void assertThrowIllegalTicketExceptionWhileTakePackage(BaseLockerRobot lockerRobot, String ticketSerialNo) {
        assertThrowIllegalTicketException(() -> lockerRobot.takePackage(new Ticket(ticketSerialNo)));
    }
}
