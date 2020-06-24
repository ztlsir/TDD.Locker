package com.ztlsir;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.ztlsir.fixture.LockerAssertFixture.assertTicketAndPackSavedLocker;
import static com.ztlsir.fixture.LockerCreatorFixture.createAvailableLocker;
import static com.ztlsir.fixture.LockerCreatorFixture.createFullLocker;
import static com.ztlsir.fixture.LockerRobotAssertFixture.assertThrowIllegalTicketExceptionWhileTakePackage;
import static com.ztlsir.fixture.LockerRobotAssertFixture.assertThrowLockerFullExceptionWhileSavePackage;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Given 机器人管理2个储物柜，2个储物柜都没满 When 存包 Then 获得一张有效票据，包存到第1个储物柜
 * Given 机器人管理2个储物柜，第1个储物柜已满，第2个储物柜未满 When 存包 Then 获得一张有效票据，包存到第2个储物柜
 * Given 机器人管理2个储物柜，第1个储物柜未满，第2个储物柜已满 When 存包 Then 获得一张有效票据，包存到第1个储物柜
 * Given 机器人管理2个储物柜，2个储物柜都已满 When 存包 Then 提示存包失败
 * Given 一张有效票据 When 取包 Then 取包成功
 * Given 一张伪造票据 When 取包 Then 取包失败，提示非法票据
 * Given 一张已取过包的票据 When 取包 Then 取包失败，提示非法票据
 * */
public class PrimaryLockerRobotTest {

    @Test
    public void should_save_in_1st_locker_and_return_ticket_when_save_package_given_robot_manage_two_lockers_and_both_is_not_full() {
        Locker firstLocker = createAvailableLocker();
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(firstLocker, createAvailableLocker()));
        Pack preSavePack = new Pack();

        Ticket ticket = primaryLockerRobot.savePackage(preSavePack);

        assertTicketAndPackSavedLocker(firstLocker, preSavePack, ticket);
    }

    @Test
    public void should_save_in_2st_locker_and_return_ticket_when_save_package_given_robot_manage_two_lockers_and_first_locker_is_full_and_second_locker_is_not_full() {
        Locker secondLocker = createAvailableLocker();
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(createFullLocker(), secondLocker));
        Pack preSavePack = new Pack();

        Ticket ticket = primaryLockerRobot.savePackage(preSavePack);

        assertTicketAndPackSavedLocker(secondLocker, preSavePack, ticket);
    }

    @Test
    public void should_save_in_1st_locker_and_return_ticket_when_save_package_given_robot_manage_two_lockers_and_first_locker_is_not_full_and_second_locker_is_full() {
        Locker firstLocker = createAvailableLocker();
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(firstLocker, createFullLocker()));
        Pack preSavePack = new Pack();

        Ticket ticket = primaryLockerRobot.savePackage(preSavePack);

        assertTicketAndPackSavedLocker(firstLocker, preSavePack, ticket);
    }

    @Test
    public void should_throw_locker_full_exception_when_save_package_given_robot_manage_two_lockers_and_both_is_full() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(createFullLocker(), createFullLocker()));
        Pack preSavePack = new Pack();

        assertThrowLockerFullExceptionWhileSavePackage(primaryLockerRobot, preSavePack);
    }

    @Test
    public void should_take_package_by_ticket_when_take_package_given_useful_ticket_and_package_save_in_1st_locker() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(createAvailableLocker(), createAvailableLocker()));
        Pack preSavePack = new Pack();
        Ticket ticket = primaryLockerRobot.savePackage(preSavePack);

        Pack pack = primaryLockerRobot.takePackage(new Ticket(ticket.getSerialNo()));

        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_take_package_by_ticket_when_take_package_given_useful_ticket_and_package_save_in_2nd_locker() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(createFullLocker(), createAvailableLocker()));
        Pack preSavePack = new Pack();
        Ticket ticket = primaryLockerRobot.savePackage(preSavePack);

        Pack pack = primaryLockerRobot.takePackage(new Ticket(ticket.getSerialNo()));

        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_throw_ilLegal_ticket_exception_when_take_package_given_fake_ticket() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(createFullLocker(), createAvailableLocker()));

        assertThrowIllegalTicketExceptionWhileTakePackage(primaryLockerRobot, "fake_ticket");
    }

    @Test
    public void should_throw_ilLegal_ticket_exception_when_take_package_given_has_taken_ticket_from_1st_locker() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(createAvailableLocker(), createAvailableLocker()));
        Pack preSavePack = new Pack();
        Ticket ticket = primaryLockerRobot.savePackage(preSavePack);
        primaryLockerRobot.takePackage(new Ticket(ticket.getSerialNo()));

        assertThrowIllegalTicketExceptionWhileTakePackage(primaryLockerRobot, ticket.getSerialNo());
    }

    @Test
    public void should_throw_ilLegal_ticket_exception_when_take_package_given_has_taken_ticket_from_2nd_locker() {
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(createFullLocker(), createAvailableLocker()));
        Pack preSavePack = new Pack();
        Ticket ticket = primaryLockerRobot.savePackage(preSavePack);
        primaryLockerRobot.takePackage(new Ticket(ticket.getSerialNo()));

        assertThrowIllegalTicketExceptionWhileTakePackage(primaryLockerRobot, ticket.getSerialNo());
    }
}
