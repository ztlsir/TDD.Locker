package com.ztlsir.locker.robot;

import com.ztlsir.locker.Locker;
import com.ztlsir.locker.Ticket;

import java.util.List;

public abstract class ManageLockersRobot extends BaseLockerRobot {

    ManageLockersRobot(List<Locker> lockers) {
        super(lockers);
    }

    boolean isSaved(Ticket ticket) {
        return this.lockers.isSaved(ticket);
    }

    boolean isNotFull() {
        return this.lockers.isNotFull();
    }
}
