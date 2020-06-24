package com.ztlsir;

import java.util.List;

public abstract class ManageLockersRobot extends BaseLockerRobot {

    ManageLockersRobot(List<Locker> lockers) {
        super(lockers);
    }

    boolean isSaved(Ticket ticket) {
        return this.lockers.stream().anyMatch(locker -> locker.isSaved(ticket));
    }

    boolean isNotFull() {
        return this.lockers.stream().anyMatch(Locker::isNotFull);
    }
}
