package com.ztlsir.locker;

import java.util.List;

public class SmartLockerRobot extends ManageLockersRobot {
    public SmartLockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    @Override
    public Ticket savePackage(Pack pack) {
        return lockers.saveToMaxRemainingCapacityLocker(pack);
    }
}