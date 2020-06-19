package com.ztlsir;

import java.util.List;

public class SmartLockerRoot {
    private final List<Locker> lockers;

    public SmartLockerRoot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket savePackage(Pack pack) {
        return this.lockers.get(0).savePackage(pack);
    }
}
