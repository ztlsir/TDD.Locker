package com.ztlsir;

import com.ztlsir.exception.IlLegalTicketException;

import java.util.Comparator;
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

        throw new IlLegalTicketException();
    }
}
