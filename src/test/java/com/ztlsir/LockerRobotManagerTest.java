package com.ztlsir;

import com.ztlsir.exception.LockerFullException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.ztlsir.fixture.LockerAssertFixture.*;
import static com.ztlsir.fixture.LockerCreatorFixture.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * done Given LockerRobotManager管理着2个有容量的机器人、和2个有容量的locker，第1个机器人为PrimaryLockerRobot，第2个机器人为SmartLockerRobot
 * When 存包
 * Then 获得一张有效票据，包存到PrimaryLockerRobot管理的locker
 * <p>
 * done Given LockerRobotManager管理着2个有容量的机器人、和2个有容量的locker，第1个机器人为SmartLockerRobot，第2个机器人为PrimaryLockerRobot
 * When 存包
 * Then 获得一张有效票据，包存到SmartLockerRobot管理的locker
 * <p>
 * done Given LockerRobotManager管理着2个机器人、和2个有容量的locker，第1个机器人SmartLockerRobot没有容量，第2个机器人PrimaryLockerRobot有容量
 * When 存包
 * Then 获得一张有效票据，包存到PrimaryLockerRobot管理的locker
 * <p>
 * done Given LockerRobotManager管理着2个没有容量的机器人和2个有容量的locker
 * When 存包
 * Then 获得一张有效票据，包存到第1个locker
 * <p>
 * done Given LockerRobotManager管理着2个没有容量的机器人和2个locker，第1个locker没有容量，第2个locker有容量
 * When 存包
 * Then 获得一张有效票据，包存到第2个locker
 * <p>
 * Given LockerRobotManager管理着2个有容量的机器人，第1个机器人为SmartLockerRobot，第2个机器人为PrimaryLockerRobot
 * When 存包
 * Then 获得一张有效票据，包存到SmartLockerRobot管理的locker
 * <p>
 * done Given LockerRobotManager管理着2个机器人，第1个机器人SmartLockerRobot没有容量，第2个机器人PrimaryLockerRobot有容量
 * When 存包
 * Then 获得一张有效票据，包存到PrimaryLockerRobot管理的locker
 * <p>
 * done Given LockerRobotManager管理着2个有容量的locker
 * When 存包
 * Then 获得一张有效票据，包存到第1个locker
 * <p>
 * done Given LockerRobotManager管理着2个locker，第1个locker没有容量，第2个locker有容量
 * When 存包
 * Then 获得一张有效票据，包存到第2个locker
 * <p>
 * done Given LockerRobotManager管理着2个没有容量的机器人和2个没有容量的locker
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

        verifySaveToFisrtOfLockers(primaryAvailableLockers, manager);
    }

    @Test
    public void should_return_ticket_and_save_to_locker_of_smart_locker_robot_when_save_package_given_locker_robot_manager_manage_two_available_robot_and_two_available_locker_that_locker_robot_is_smart_and_primary() {
        List<Locker> smartAvailableLockers = createAvailableLockers(1);
        LockerRobotManager manager = new LockerRobotManager(
                Arrays.asList(
                        new SmartLockerRobot(smartAvailableLockers),
                        new PrimaryLockerRobot(createAvailableLockers(1))),
                createAvailableLockers(2));

        verifySaveToFisrtOfLockers(smartAvailableLockers, manager);
    }

    @Test
    public void should_return_ticket_and_save_to_locker_of_primary_locker_robot_when_save_package_given_locker_robot_manager_manage_two_robot_and_two_available_locker_that_locker_robot_smart_is_full_and_primary_is_available() {
        List<Locker> primaryAvailableLockers = createAvailableLockers(1);
        LockerRobotManager manager = new LockerRobotManager(
                Arrays.asList(
                        new SmartLockerRobot(createFullLockers()),
                        new PrimaryLockerRobot(primaryAvailableLockers)),
                createAvailableLockers(2));

        verifySaveToFisrtOfLockers(primaryAvailableLockers, manager);
    }

    @Test
    public void should_return_ticket_and_save_to_1st_locker_when_save_package_given_locker_robot_manager_manage_two_full_robot_and_two_available_locker() {
        List<Locker> lockers = createAvailableLockers(2);
        LockerRobotManager manager = new LockerRobotManager(
                Arrays.asList(
                        new SmartLockerRobot(createFullLockers()),
                        new PrimaryLockerRobot(createFullLockers())),
                lockers);

        verifySaveToFisrtOfLockers(lockers, manager);
    }

    @Test
    public void should_return_ticket_and_save_to_2nd_locker_when_save_package_given_locker_robot_manager_manage_two_full_robot_and_1st_full_locker_and_2nd_available_locker() {
        List<Locker> lockers = Arrays.asList(createFullLocker(), createAvailableLocker());
        LockerRobotManager manager = new LockerRobotManager(
                Arrays.asList(
                        new SmartLockerRobot(createFullLockers()),
                        new PrimaryLockerRobot(createFullLockers())),
                lockers);

        verifySaveToSpecifiedPositionOfLockers(manager, lockers, 2);
    }

    @Test
    public void should_return_ticket_and_save_to_locker_of_smart_locker_robot_when_save_package_given_locker_robot_manager_manage_two_available_robot_that_locker_robot_is_smart_and_primary() {
        List<Locker> smartAvailableLockers = createAvailableLockers(1);
        LockerRobotManager manager = new LockerRobotManager(
                Arrays.asList(
                        new SmartLockerRobot(smartAvailableLockers),
                        new PrimaryLockerRobot(createAvailableLockers(1))));

        verifySaveToFisrtOfLockers(smartAvailableLockers, manager);
    }

    @Test
    public void should_return_ticket_and_save_to_locker_of_primary_locker_robot_when_save_package_given_locker_robot_manager_manage_two_robot_that_locker_robot_smart_is_full_and_primary_is_available() {
        List<Locker> primaryAvailableLockers = createAvailableLockers(1);
        LockerRobotManager manager = new LockerRobotManager(
                Arrays.asList(
                        new SmartLockerRobot(createFullLockers()),
                        new PrimaryLockerRobot(primaryAvailableLockers)));

        verifySaveToFisrtOfLockers(primaryAvailableLockers, manager);
    }

    @Test
    public void should_return_ticket_and_save_to_1st_locker_when_save_package_given_locker_robot_manager_manage_two_available_locker() {
        List<Locker> lockers = createAvailableLockers(2);
        LockerRobotManager manager = LockerRobotManager.create(lockers);

        verifySaveToFisrtOfLockers(lockers, manager);
    }

    @Test
    public void should_return_ticket_and_save_to_2nd_locker_when_save_package_given_locker_robot_manager_manage_1st_full_locker_and_2nd_available_locker() {
        List<Locker> lockers = Arrays.asList(createFullLocker(), createAvailableLocker());
        LockerRobotManager manager = LockerRobotManager.create(lockers);

        verifySaveToSpecifiedPositionOfLockers(manager, lockers, 2);
    }

    @Test
    public void should_throw_locker_full_exception_when_save_package_given_locker_robot_manager_manage_two_full_robot_and_two_full_locker() {
        LockerRobotManager manager = new LockerRobotManager(
                Arrays.asList(
                        new SmartLockerRobot(createFullLockers()),
                        new PrimaryLockerRobot(createFullLockers())),
                createFullLockers());
        Pack preSavePack = new Pack();

        assertThrowLockerFullException(() -> manager.savePackage(preSavePack));
    }

    private static void verifySaveToFisrtOfLockers(List<Locker> lockers, LockerRobotManager manager) {
        verifySaveToSpecifiedPositionOfLockers(manager, lockers, 1);
    }

    private static void verifySaveToSpecifiedPositionOfLockers(LockerRobotManager manager, List<Locker> lockers, int specifiedPosition) {
        Pack preSavePack = new Pack();

        Ticket ticket = manager.savePackage(preSavePack);

        assertTicketNotEmpty(ticket);
        assertSaveToSpecifiedPositionOfLockers(lockers, preSavePack, ticket, specifiedPosition);
    }

    private static void assertSaveToSpecifiedPositionOfLockers(List<Locker> lockers, Pack preSavePack, Ticket ticket, int specifiedPosition) {
        Pack pack = lockers.get(specifiedPosition - 1).takePackage(new Ticket(ticket.getSerialNo()));
        assertEquals(preSavePack, pack);
    }

    private static List<Locker> createAvailableLockers(int lockerCount) {
        List<Locker> lockers = new ArrayList<>();
        for (int index = 0; index < lockerCount; index++) {
            lockers.add(createAvailableLocker());
        }

        return lockers;
    }

    private static List<Locker> createFullLockers() {
        return Arrays.asList(createFullLocker());
    }
}
