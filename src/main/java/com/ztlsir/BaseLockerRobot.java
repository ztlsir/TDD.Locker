package com.ztlsir;

import com.ztlsir.exception.IllegalTicketException;

import java.util.List;

public abstract class BaseLockerRobot {
    final List<Locker> lockers;

    BaseLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public abstract Ticket savePackage(Pack pack);

    public Pack takePackage(Ticket ticket) {
        return this.lockers.stream()
                .filter(locker -> locker.isSaved(ticket))
                .findAny()
                .orElseThrow(IllegalTicketException::new)
                .takePackage(ticket);
    }
}
