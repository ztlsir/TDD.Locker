package com.ztlsir.fixture;

import com.ztlsir.ManageLockersRobot;
import com.ztlsir.Pack;
import com.ztlsir.Ticket;

import static com.ztlsir.fixture.LockerAssertFixture.assertThrowIllegalTicketException;
import static com.ztlsir.fixture.LockerAssertFixture.assertThrowLockerFullException;

public class LockerRobotAssertFixture {
    public static void assertThrowLockerFullExceptionWhileSavePackage(ManageLockersRobot lockerRobot, Pack preSavePack) {
        assertThrowLockerFullException(() -> lockerRobot.savePackage(preSavePack));
    }

    public static void assertThrowIllegalTicketExceptionWhileTakePackage(ManageLockersRobot lockerRobot, String ticketSerialNo) {
        assertThrowIllegalTicketException(() -> lockerRobot.takePackage(new Ticket(ticketSerialNo)));
    }
}
