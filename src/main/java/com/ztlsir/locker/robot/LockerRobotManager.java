package com.ztlsir.locker.robot;

import com.ztlsir.locker.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LockerRobotManager extends BaseLockerRobot {
    private final List<ManageLockersRobot> manageLockersRobots;

    public static LockerRobotManager create(List<Locker> lockers) {
        return new LockerRobotManager(new ArrayList<>(), lockers);
    }

    public LockerRobotManager(List<ManageLockersRobot> manageLockersRobots, List<Locker> lockers) {
        super(lockers);
        this.manageLockersRobots = manageLockersRobots;
    }

    public LockerRobotManager(List<ManageLockersRobot> manageLockersRobots) {
        this(manageLockersRobots, new ArrayList<>());
    }

    @Override
    public Ticket savePackage(Pack pack) {
        Optional<ManageLockersRobot> optionalLockerRobot = this.manageLockersRobots.stream()
                .filter(ManageLockersRobot::isNotFull)
                .findFirst();

        if (optionalLockerRobot.isPresent()) {
            return optionalLockerRobot.get().savePackage(pack);
        }

        return this.lockers.saveToFirstAvailableLocker(pack);
    }

    public Pack takePackage(Ticket ticket) {
        Optional<ManageLockersRobot> optionalLockerRobot = this.manageLockersRobots.stream()
                .filter(lockerRobot -> lockerRobot.isSaved(ticket))
                .findAny();

        if (optionalLockerRobot.isPresent()) {
            return optionalLockerRobot.get().takePackage(ticket);
        }

        return super.takePackage(ticket);

    }

    public Report getReport() {
        List<Report> reports = this.lockers.getReports();
        reports.addAll(this.manageLockersRobots.stream()
                .map(ManageLockersRobot::getReport)
                .collect(Collectors.toList()));

        return new Report(ReportType.M, reports);
    }
}
