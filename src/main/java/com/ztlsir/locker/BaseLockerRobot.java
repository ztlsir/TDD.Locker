package com.ztlsir.locker;

import java.util.List;

public abstract class BaseLockerRobot {
    final Lockers lockers;

    BaseLockerRobot(List<Locker> lockers) {
        this.lockers = new Lockers(lockers);
    }

    public abstract Ticket savePackage(Pack pack);

    public Pack takePackage(Ticket ticket) {
        return this.lockers.take(ticket);
    }
}
