package com.ztlsir;

import com.ztlsir.exception.IllegalTicketException;

import java.util.List;

public abstract class BaseLockerRobot {
    protected final List<Locker> lockers;

    public BaseLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public abstract Ticket savePackage(Pack pack);

    public Pack takePackage(Ticket ticket) {
        for (Locker locker : this.lockers) {
            if (locker.isSaved(ticket)) {
                return locker.takePackage(ticket);
            }
        }

        throw new IllegalTicketException();
    }

    public boolean isSaved(Ticket ticket) {
        return this.lockers.stream()
                .anyMatch(locker -> locker.isSaved(ticket));
    }
}
