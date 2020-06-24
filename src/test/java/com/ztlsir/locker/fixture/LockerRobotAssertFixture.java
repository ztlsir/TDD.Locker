package com.ztlsir.locker.fixture;

import com.ztlsir.locker.Pack;
import com.ztlsir.locker.Ticket;
import com.ztlsir.locker.robot.ManageLockersRobot;

public class LockerRobotAssertFixture {
    public static void assertThrowLockerFullExceptionWhileSavePackage(ManageLockersRobot lockerRobot, Pack preSavePack) {
        LockerAssertFixture.assertThrowLockerFullException(() -> lockerRobot.savePackage(preSavePack));
    }

    public static void assertThrowIllegalTicketExceptionWhileTakePackage(ManageLockersRobot lockerRobot, String ticketSerialNo) {
        LockerAssertFixture.assertThrowIllegalTicketException(() -> lockerRobot.takePackage(new Ticket(ticketSerialNo)));
    }
}
