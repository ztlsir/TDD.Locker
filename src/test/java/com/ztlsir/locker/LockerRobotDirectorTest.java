package com.ztlsir.locker;

import com.ztlsir.locker.robot.LockerRobotManager;
import com.ztlsir.locker.robot.PrimaryLockerRobot;
import com.ztlsir.locker.robot.SmartLockerRobot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *done Given Director管理1个manager，manager管理1个Locker，余量和容量分别为：2和4
 * When 获取报表
 * Then 获得报表：
 * M 2 4
 *   L 2 4
 *
 *done Given Director管理1个manager，manager管理2个Locker，余量分别为：2和1，容量分别为：6和8
 * When 获取报表
 * Then 获得报表：
 * M 3 14
 *   L 2 6
 *   L 1 8
 *
 *done Given Director管理1个manager，manager管理1个PrimaryLockerRobot，PrimaryLockerRobot管理了2个Locker，余量分别为：3和2，容量分别为：9和10
 * When 获取报表
 * Then 获得报表：
 * M 5 19
 *   R 5 19
 *     L 3 9
 *     L 2 10
 *
 *done Given Director管理1个manager，manager管理1个PrimaryLockerRobot和1个SmartLockerRobot，PrimaryLockerRobot管理了3个Locker，余量分别为：1、4、4，容量分别为：13、10、11，SmartLockerRobot管理了1个Locker，余量分别为：2和5，容量分别为：11和12
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
 *done Given Director管理1个manager，manager管理1个PrimaryLockerRobot和1个Locker，PrimaryLockerRobot管理了1个Locker，余量和容量分别为：6和16，Locker余量和容量分别为：3和10
 * When 获取报表
 * Then 获得报表：
 * M 9 26
 *   L 3 10
 *   R 6 16
 *     L 6 16
 *
 *done Given Director管理2个manager，manager1管理1个PrimaryLockerRobot和1个Locker，PrimaryLockerRobot管理了1个Locker，余量和容量分别为：2和6，Locker余量和容量分别为：7和15；manager2管理1个SmartLockerRobot和1个Locker，SmartLockerRobot管理了1个Locker，余量和容量分别为：1和12，Locker余量和容量分别为：2和9
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
 *done Given Director管理1个manager，manager管理1个PrimaryLockerRobot和1个Locker，PrimaryLockerRobot管理了1个Locker，余量和容量分别为：4和12，Locker余量和容量分别为：1和9；Director未管理1个PrimaryLockerRobot，该PrimaryLockerRobot管理了1个Locker，余量和容量分别为：2和18
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
    public void should_print_report_when_query_report_given_dirctor_manage_one_manager_that_manage_one_locker_with_remain_is_2_and_capacity_is_4() {
        LockerRobotManager manager = LockerRobotManager.create(Collections.singletonList(createLocker(4, 2)));
        LockerRobotDirector director = new LockerRobotDirector(Collections.singletonList(manager));

        director.printReport();

        assertEquals("M 2 4\r\n  L 2 4", outContent.toString());
    }

    @Test
    public void should_print_report_when_query_report_given_dirctor_manage_one_manager_that_manage_two_locker_with_remain_is_2_1_and_capacity_is_6_8() {
        LockerRobotManager manager = LockerRobotManager
                .create(Arrays.asList(
                        createLocker(6, 2),
                        createLocker(8, 1)));
        LockerRobotDirector director = new LockerRobotDirector(Collections.singletonList(manager));

        director.printReport();

        assertEquals("M 3 14\r\n  L 2 6\r\n  L 1 8", outContent.toString());
    }

    @Test
    public void should_print_report_when_query_report_given_dirctor_manage_one_manager_that_manage_one_primary_that_manage_two_locker_with_remain_is_3_2_and_capacity_is_9_10() {
        LockerRobotManager manager = new LockerRobotManager(
                Collections.singletonList(new PrimaryLockerRobot(
                        Arrays.asList(
                                createLocker(9, 3),
                                createLocker(10, 2)))));
        LockerRobotDirector director = new LockerRobotDirector(Collections.singletonList(manager));

        director.printReport();

        assertEquals(
                "M 5 19\r\n  R 5 19\r\n    L 3 9\r\n    L 2 10",
                outContent.toString());
    }

    @Test
    public void should_print_report_when_query_report_given_dirctor_manage_one_manager_that_manage_two_robot_that_1st_primary_manage_three_locker_with_remain_is_1_4_4_and_capacity_is_13_10_11_and_2nd_smart_manage_two_locker_with_remain_is_2_5_and_capacity_is_11_12() {
        LockerRobotManager manager = new LockerRobotManager(
                Arrays.asList(
                        new PrimaryLockerRobot(
                                Arrays.asList(
                                        createLocker(13, 1),
                                        createLocker(10, 4),
                                        createLocker(11, 4))),
                        new SmartLockerRobot(
                                Arrays.asList(
                                        createLocker(11, 2),
                                        createLocker(12, 5)))));
        LockerRobotDirector director = new LockerRobotDirector(Collections.singletonList(manager));

        director.printReport();

        assertEquals(
                "M 16 57\r\n  R 9 34\r\n    L 1 13\r\n    L 4 10\r\n    L 4 11\r\n  R 7 23\r\n    L 2 11\r\n    L 5 12",
                outContent.toString());
    }

    @Test
    public void should_print_report_when_query_report_given_dirctor_manage_one_manager_that_manage_one_primary_and_one_locker_that_locker_remain_and_capacity_is_3_10_and_primary_manage_one_locker_with_remain_and_capacity_is_6_16() {
        LockerRobotManager manager = new LockerRobotManager(
                Collections.singletonList(new PrimaryLockerRobot(Collections.singletonList(createLocker(16, 6)))),
                Collections.singletonList(createLocker(10, 3)));
        LockerRobotDirector director = new LockerRobotDirector(Collections.singletonList(manager));

        director.printReport();

        assertEquals(
                "M 9 26\r\n  L 3 10\r\n  R 6 16\r\n    L 6 16",
                outContent.toString());
    }

    @Test
    public void should_print_report_when_query_report_given_dirctor_manage_two_manager_that_1st_manage_one_primary_and_one_locker_that_locker_remain_and_capacity_is_7_15_and_primary_manage_one_locker_with_remain_and_capacity_is_2_6_and_2nd_manage_one_smart_and_one_locker_that_locker_remain_and_capacity_is_2_9_and_primary_manage_one_locker_with_remain_and_capacity_is_1_12() {
        LockerRobotManager firstManager = new LockerRobotManager(
                Collections.singletonList(new PrimaryLockerRobot(Collections.singletonList(createLocker(6, 2)))),
                Collections.singletonList(createLocker(15, 7)));
        LockerRobotManager secondManager = new LockerRobotManager(
                Collections.singletonList(new SmartLockerRobot(Collections.singletonList(createLocker(12, 1)))),
                Collections.singletonList(createLocker(9, 2)));
        LockerRobotDirector director = new LockerRobotDirector(Arrays.asList(firstManager,secondManager));

        director.printReport();

        assertEquals(
                "M 9 21\r\n  L 7 15\r\n  R 2 6\r\n    L 2 6\r\nM 3 21\r\n  L 2 9\r\n  R 1 12\r\n    L 1 12",
                outContent.toString());
    }

    @Test
    public void should_print_report_when_query_report_given_dirctor_manage_one_manager_that_manage_one_primary_and_one_locker_that_locker_remain_and_capacity_is_1_9_and_primary_manage_one_locker_with_remain_and_capacity_is_4_12_and_dirctor_did_not_manage_one_manager_that_manage_one_primary_that_manage_one_locker_with_remain_and_capacity_is_2_18() {
        LockerRobotManager manager = new LockerRobotManager(
                Collections.singletonList(new PrimaryLockerRobot(Collections.singletonList(createLocker(12, 4)))),
                Collections.singletonList(createLocker(9, 1)));
        new LockerRobotManager(
                Collections.singletonList(new PrimaryLockerRobot(Collections.singletonList(createLocker(18, 2)))));
        LockerRobotDirector director = new LockerRobotDirector(Collections.singletonList(manager));

        director.printReport();

        assertEquals(
                "M 5 21\r\n  L 1 9\r\n  R 4 12\r\n    L 4 12",
                outContent.toString());
    }

    private Locker createLocker(int capacity, int remain) {
        Locker locker = new Locker(capacity);
        for (int i = 0; i < capacity - remain; i++) {
            locker.savePackage(new Pack());
        }

        return locker;
    }
}
