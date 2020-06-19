package com.ztlsir;

import com.ztlsir.exception.LockerFullException;

import java.util.List;

public class PrimaryLockerRobot extends BaseLockerRobot {
    public PrimaryLockerRobot(List<Locker> lockers) {
        super(lockers);
    }

    @Override
    public Ticket savePackage(Pack pack) {
        for (Locker locker : this.lockers) {
            if (locker.isNotFull()) {
                return locker.savePackage(pack);
            }
        }

        throw new LockerFullException();
    }
}
