package com.ztlsir;

import com.ztlsir.exception.IlLegalTicketException;

import java.util.Comparator;
import java.util.List;

public class SmartLockerRobot extends BaseLockerRobot {
    public SmartLockerRobot(List<Locker> lockers) {
        super(lockers);
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
}
