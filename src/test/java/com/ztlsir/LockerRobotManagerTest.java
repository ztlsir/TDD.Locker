package com.ztlsir;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.ztlsir.fixture.LockerFixture.assertTicketNotEmpty;
import static com.ztlsir.fixture.LockerFixture.createAvailableLocker;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * done Given LockerRobotManager管理着2个有容量的机器人、和2个有容量的locker，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot
 * When 存包
 * Then 获得一张有效票据，包存到PrimaryLockerRobot管理的locker
 * <p>
 * done Given LockerRobotManager管理着2个有容量的机器人、和2个有容量的locker，第1个机器人为SmartLockerRobot，第2个机器人为PrimaryLockerRobot
 * When 存包
 * Then 获得一张有效票据，包存到SmartLockerRobot管理的locker
 * <p>
 * todo Given LockerRobotManager管理着2个机器人、和2个有容量的locker，第1个机器人SmartLockerRobot没有容量，第2个机器人PrimaryLockerRobot有容量
 * When 存包
 * Then 获得一张有效票据，包存到PrimaryLockerRobot管理的locker
 * <p>
 * todo Given LockerRobotManager管理着2个没有容量的机器人和2个有容量的locker
 * When 存包
 * Then 获得一张有效票据，包存到第1个locker
 * <p>
 * todo Given LockerRobotManager管理着2个没有容量的机器人和2个locker，第1个locker没有容量，第2个locker有容量
 * When 存包
 * Then 获得一张有效票据，包存到第2个locker
 * <p>
 * todo Given LockerRobotManager管理着2个有容量的机器人，第1个机器人为SmartLockerRobot，第2个机器人为PrimaryLockerRobot
 * When 存包
 * Then 获得一张有效票据，包存到PrimaryLockerRobot管理的locker
 * <p>
 * todo Given LockerRobotManager管理着2个机器人，第1个机器人SmartLockerRobot没有容量，第2个机器人PrimaryLockerRobot有容量
 * When 存包
 * Then 获得一张有效票据，包存到PrimaryLockerRobot管理的locker
 * <p>
 * todo Given LockerRobotManager管理着2个有容量的locker
 * When 存包
 * Then 获得一张有效票据，包存到第1个locker
 * <p>
 * todo Given LockerRobotManager管理着2个locker，第1个locker没有容量，第2个locker有容量
 * When 存包
 * Then 获得一张有效票据，包存到第2个locker
 * <p>
 * todo Given LockerRobotManager管理着2个没有容量的机器人和2个没有容量的locker
 * When 存包
 * Then 存包失败，提示储物柜已满
 * <p>
 * todo Given LockerRobotManager管理着2个没有容量的机器人
 * When 存包
 * Then 存包失败，提示储物柜已满
 * <p>
 * todo Given LockerRobotManager管理着2个没有容量的locker
 * When 存包
 * Then 存包失败，提示储物柜已满
 * <p>
 * todo Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot，一张包存在第1个机器人的有效票
 * When 取包
 * Then 取包成功
 * <p>
 * todo Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot，一张包存在第2个机器人的有效票
 * When 取包
 * Then 取包成功
 * <p>
 * todo Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，一张包存在第1个locker的有效票
 * When 取包
 * Then 取包成功
 * <p>
 * todo Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，一张包存在第2个locker的有效票
 * When 取包
 * Then 取包成功
 * <p>
 * todo Given LockerRobotManager管理着2个有容量的机器人，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot，一张包存在第1个机器人的有效票
 * When 取包
 * Then 取包成功
 * <p>
 * todo Given LockerRobotManager管理着2个有容量的机器人，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot，一张包存在第2个机器人的有效票
 * When 取包
 * Then 取包成功
 * <p>
 * todo Given LockerRobotManager管理着2个有容量的locker，一张包存在第1个locker的有效票
 * When 取包
 * Then 取包成功
 * <p>
 * todo Given LockerRobotManager管理着2个有容量的locker，一张包存在第2个locker的有效票
 * When 取包
 * Then 取包成功
 * <p>
 * todo Given LockerRobotManager管理着2个有容量的机器人和2个有容量的locker，一张伪造票据
 * When 取包
 * Then 取包失败，提示非法票据
 * <p>
 * todo Given LockerRobotManager管理着2个有容量的机器人，一张伪造票据
 * When 取包
 * Then 取包失败，提示非法票据
 * <p>
 * todo Given LockerRobotManager管理着2个有容量的locker，一张伪造票据
 * When 取包
 * Then 取包失败，提示非法票据
 */
public class LockerRobotManagerTest {
    @Test
    public void should_return_ticket_and_save_to_locker_of_primary_locker_robot_when_save_package_given_locker_robot_manager_manage_two_available_robot_and_two_available_locker_that_locker_robot_is_primary_and_smart() {
        List<Locker> primaryAvailableLockers = createAvailableLockers(1);
        LockerRobotManager manager = new LockerRobotManager(
                Arrays.asList(
                        new PrimaryLockerRobot(primaryAvailableLockers),
                        new SmartLockerRobot(createAvailableLockers(1))),
                createAvailableLockers(2));
        Pack preSavePack = new Pack();

        Ticket ticket = manager.savePackage(preSavePack);

        assertTicketNotEmpty(ticket);
        Pack pack = primaryAvailableLockers.get(0).takePackage(new Ticket(ticket.getSerialNo()));
        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_return_ticket_and_save_to_locker_of_primary_locker_robot_when_save_package_given_locker_robot_manager_manage_two_available_robot_and_two_available_locker_that_locker_robot_is_smart_and_primary() {
        List<Locker> smartAvailableLockers = createAvailableLockers(1);
        LockerRobotManager manager = new LockerRobotManager(
                Arrays.asList(
                        new SmartLockerRobot(smartAvailableLockers),
                        new PrimaryLockerRobot(createAvailableLockers(1))),
                createAvailableLockers(2));
        Pack preSavePack = new Pack();

        Ticket ticket = manager.savePackage(preSavePack);

        assertTicketNotEmpty(ticket);
        Pack pack = smartAvailableLockers.get(0).takePackage(new Ticket(ticket.getSerialNo()));
        assertEquals(preSavePack, pack);
    }

    private static List<Locker> createAvailableLockers(int lockerCount) {
        List<Locker> lockers = new ArrayList<>();
        for (int index = 0; index < lockerCount; index++) {
            lockers.add(createAvailableLocker());
        }

        return lockers;
    }
}
