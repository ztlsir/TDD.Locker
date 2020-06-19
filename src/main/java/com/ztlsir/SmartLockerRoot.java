package com.ztlsir;

import com.ztlsir.exception.IlLegalTicketException;

import java.util.Comparator;
import java.util.List;

public class SmartLockerRoot {
    private final List<Locker> lockers;

    public SmartLockerRoot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket savePackage(Pack pack) {
        return lockers.stream()
                .sorted(Comparator
                        .comparing(Locker::getCapacityPackCount)
                        .reversed()
                        .thenComparing(Locker::getOrder))
                .findFirst()
                .get()
                .savePackage(pack);
    }

    public Pack takePackage(Ticket ticket) {
        for (Locker locker : this.lockers) {
            if (locker.isSaved(ticket)) {
                return locker.takePackage(ticket);
            }
        }

        throw new IlLegalTicketException();
    }
}
