package com.ztlsir;

import java.util.List;

public class PrimaryLockerRobot {
    private final List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public String savePackage(Pack pack) {
        return lockers.get(0).savePackage(pack);
    }
}
