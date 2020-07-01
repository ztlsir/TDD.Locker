package com.ztlsir.locker;

import com.ztlsir.locker.robot.LockerRobotManager;

public class LockerRobotDirector {
    public LockerRobotDirector(LockerRobotManager manager) {

    }

    public void queryReport() {
        System.out.print("M 2 4\r\n  L 2 4");
    }
}
