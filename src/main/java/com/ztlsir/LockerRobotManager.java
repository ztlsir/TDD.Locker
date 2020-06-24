package com.ztlsir;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LockerRobotManager {
    private final List<BaseLockerRobot> lockerRobots;
    private final List<Locker> lockers;

    public LockerRobotManager(List<BaseLockerRobot> lockerRobots, List<Locker> lockers) {
        this.lockerRobots = lockerRobots;
        this.lockers = lockers;
    }

    public LockerRobotManager(List<BaseLockerRobot> lockerRobots) {
        this(lockerRobots,new ArrayList<Locker>());
    }

    public Ticket savePackage(Pack pack) {
        Optional<BaseLockerRobot> optionalBaseLockerRobot = lockerRobots.stream()
                .filter(lockerRobot -> lockerRobot.lockers.stream().anyMatch(locker -> locker.isNotFull()))
                .findFirst();

        if (optionalBaseLockerRobot.isPresent()) {
            return optionalBaseLockerRobot.get().savePackage(pack);
        }

        return lockers.stream()
                .filter(locker -> locker.isNotFull())
                .findFirst()
                .get()
                .savePackage(pack);
    }
}
