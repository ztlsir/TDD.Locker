package com.ztlsir;

import com.ztlsir.exception.IlLegalTicketException;
import com.ztlsir.exception.LockerFullException;

import java.util.List;

public class PrimaryLockerRobot {
    private static final String ilLegalTicketErrorMessage = "非法票据";

    private final List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket savePackage(Pack pack) {
        for (Locker locker : lockers) {
            if (locker.isNotFull()) {
                return locker.savePackage(pack);
            }
        }

        throw new LockerFullException();
    }

    public Pack takePackage(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.isSaved(ticket)) {
                return locker.takePackage(ticket);
            }
        }

        throw new IlLegalTicketException();
    }
}
