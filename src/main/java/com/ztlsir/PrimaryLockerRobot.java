package com.ztlsir;

import java.util.List;

public class PrimaryLockerRobot {
    private final List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public String savePackage(Pack pack) {
        for (Locker locker : lockers) {
            if (locker.isNotFull()) {
                return locker.savePackage(pack);
            }
        }

        return null;
    }
}
