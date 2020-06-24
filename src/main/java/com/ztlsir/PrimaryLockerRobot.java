package com.ztlsir;

import java.util.List;

public class PrimaryLockerRobot extends ManageLockersRobot {
    public PrimaryLockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    @Override
    public Ticket savePackage(Pack pack) {
        return this.lockers.saveToFirstAvailableLocker(pack);
    }
}
