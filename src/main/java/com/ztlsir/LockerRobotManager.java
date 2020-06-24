package com.ztlsir;

import java.util.List;

public class LockerRobotManager {
    private final List<BaseLockerRobot> lockerRobots;

    public LockerRobotManager(List<BaseLockerRobot> lockerRobots, List<Locker> lockers) {
        this.lockerRobots = lockerRobots;
    }

    public Ticket savePackage(Pack pack) {
        return lockerRobots.stream()
                .filter(lockerRobot -> lockerRobot.lockers.stream().anyMatch(locker -> locker.isNotFull()))
                .findFirst()
                .get()
                .savePackage(pack);
    }
}
