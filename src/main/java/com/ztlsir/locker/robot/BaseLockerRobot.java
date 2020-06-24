package com.ztlsir.locker.robot;

import com.ztlsir.locker.Locker;
import com.ztlsir.locker.Lockers;
import com.ztlsir.locker.Pack;
import com.ztlsir.locker.Ticket;

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
