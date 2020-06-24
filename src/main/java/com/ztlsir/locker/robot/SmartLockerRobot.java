package com.ztlsir.locker.robot;

import com.ztlsir.locker.Locker;
import com.ztlsir.locker.Pack;
import com.ztlsir.locker.Ticket;

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