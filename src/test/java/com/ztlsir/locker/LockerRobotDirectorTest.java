package com.ztlsir.locker;

import com.ztlsir.locker.robot.LockerRobotManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *done Given Director管理1个manager，manager管理1个Locker，余量和容量分别为：2和4
 * When 获取报表
 * Then 获得报表：
 * M 2 4
 *   L 2 4
 *
 *todo Given Director管理1个manager，manager管理2个Locker，余量分别为：2和1，容量分别为：6和8
 * When 获取报表
 * Then 获得报表：
 * M 3 14
 *   L 2 6
 *   L 1 8
 *
 *todo Given Director管理1个manager，manager管理1个PrimaryLockerRobot，PrimaryLockerRobot管理了2个Locker，余量分别为：3和2，容量分别为：9和10
 * When 获取报表
 * Then 获得报表：
 * M 5 19
 *   R 5 19
 *     L 3 9
 *     L 2 10
 *
 *todo Given Director管理1个manager，manager管理1个PrimaryLockerRobot和1个SmartLockerRobot，PrimaryLockerRobot管理了3个Locker，余量分别为：1、4、4，容量分别为：13、10、11，SmartLockerRobot管理了1个Locker，余量分别为：2和5，容量分别为：11和12
 * When 获取报表
 * Then 获得报表：
 * M 16 57
 *   R 9 34
 *     L 1 13
 *     L 4 10
 *     L 4 11
 *   R 7 23
 *     L 2 11
 *     L 5 12
 *
 *todo Given Director管理1个manager，manager管理1个PrimaryLockerRobot和1个Locker，PrimaryLockerRobot管理了1个Locker，余量和容量分别为：6和16，Locker余量和容量分别为：3和10
 * When 获取报表
 * Then 获得报表：
 * M 9 26
 *   L 3 10
 *   R 6 16
 *     L 6 16
 *
 *todo Given Director管理2个manager，manager1管理1个PrimaryLockerRobot和1个Locker，PrimaryLockerRobot管理了1个Locker，余量和容量分别为：2和6，Locker余量和容量分别为：7和15；manager2管理1个SmartLockerRobot和1个Locker，SmartLockerRobot管理了1个Locker，余量和容量分别为：1和12，Locker余量和容量分别为：2和9
 * When 获取报表
 * Then 获得报表：
 * M 9 21
 *   L 7 15
 *   R 2 6
 *     L 2 6
 * M 3 21
 *   L 2 9
 *   R 1 12
 *     L 1 12
 *
 *todo Given Director管理1个manager，manager管理1个PrimaryLockerRobot和1个Locker，PrimaryLockerRobot管理了1个Locker，余量和容量分别为：4和12，Locker余量和容量分别为：1和9；Director未管理1个PrimaryLockerRobot，该PrimaryLockerRobot管理了1个Locker，余量和容量分别为：2和18
 * When 获取报表
 * Then 获得报表：
 * M 5 21
 *   L 1 9
 *   R 4 12
 *     L 4 12
 * */
public class LockerRobotDirectorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void should_print_report_when_query_report_given_dirctor_manage_one_manager_that_manage_one_locker_with_capacity_is_4_and_margin_is_2() {
        Locker locker = new Locker(4);
        locker.savePackage(new Pack());
        locker.savePackage(new Pack());
        LockerRobotManager manager = LockerRobotManager.create(Arrays.asList(locker));
        LockerRobotDirector director = new LockerRobotDirector(manager);

        director.queryReport();

        assertEquals("M 2 4\r\n  L 2 4",outContent.toString());
    }
}
