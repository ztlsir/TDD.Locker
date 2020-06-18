package com.ztlsir;

import java.util.List;

public class PrimaryLockerRobot {
    private static final String savePackageFailedErrorMessage = "存包失败";

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

        throw new RuntimeException(savePackageFailedErrorMessage);
    }
}
