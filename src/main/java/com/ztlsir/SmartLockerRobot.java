package com.ztlsir;

import java.util.Comparator;
import java.util.List;

public class SmartLockerRobot extends BaseLockerRobot {
    public SmartLockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    @Override
    public Ticket savePackage(Pack pack) {
        return lockers.stream()
                .max(Comparator.comparing(Locker::getRemainingCapacity))
                .get()
                .savePackage(pack);
    }
}