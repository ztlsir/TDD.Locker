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
        Locker maxLocker = lockers.stream()
                .sorted(Comparator.comparing(Locker::getCapacityPackCount).reversed().thenComparing(Locker::getOrder))
                .findFirst()
                .get();
        if (maxLocker.isNotFull()) {
            return maxLocker.savePackage(pack);
        }

        return null;
    }
}
