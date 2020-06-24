package com.ztlsir;

import com.ztlsir.exception.LockerFullException;

import java.util.List;

public class PrimaryLockerRobot extends ManageLockersRobot {
    public PrimaryLockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    @Override
    public Ticket savePackage(Pack pack) {
        return this.lockers.stream()
                .filter(Locker::isNotFull)
                .findFirst()
                .orElseThrow(LockerFullException::new)
                .savePackage(pack);
    }
}
