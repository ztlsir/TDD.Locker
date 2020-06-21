package com.ztlsir;

import com.ztlsir.exception.IlLegalTicketException;
import com.ztlsir.exception.LockerFullException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.ztlsir.fixture.LockerFixture.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为5，第2个储物柜容量为5 When 存包 Then 获得一张有效票据，包存到第1个储物柜
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为5，第2个储物柜容量为4 When 存包 Then 获得一张有效票据，包存到第1个储物柜
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为4，第2个储物柜容量为5 When 存包 Then 获得一张有效票据，包存到第2个储物柜
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为0，第2个储物柜容量为5 When 存包 Then 获得一张有效票据，包存到第2个储物柜
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为5，第2个储物柜容量为0 When 存包 Then 获得一张有效票据，包存到第1个储物柜
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为0，第2个储物柜容量为0 When 存包 Then 存包失败，提示储物柜已满
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，通过SmartLockerRoot存包取得的一张有效票据 When 通过SmartLockerRoot取包 Then 取包成功
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，一张伪造票据 When 通过SmartLockerRoot取包 Then 取包失败，提示非法票据
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，通过PrimaryLockerRoot存包取得的一张有效票据 When 通过SmartLockerRoot取包 Then 取包成功
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，通过SmartLockerRoot存包取得的一张有效票据 When 通过PrimaryLockerRoot取包 Then 取包成功
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为1，第2个储物柜容量为0 When 存包 Then 获得一张有效票据，包存到第1个储物柜，第1个储物柜存满
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为1，第2个储物柜容量为0 When 先存包,再通过SmartLockerRoot取包 Then 第1个储物柜有余量，第2个储物柜存满
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为2,余量为1，第2个储物柜容量为2 When 存包 Then 获得一张有效票据，包存到第2个储物柜
 */
public class SmartLockerRobotTest {
    @Test
    public void should_save_in_1st_locker_and_return_ticket_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_5_and_2nd_with_5() {
        Locker firstLocker = new Locker(5, 1);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(5, 2), firstLocker));
        Pack preSavePack = new Pack();

        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        assertTicketNotEmpty(ticket);
        Pack pack = firstLocker.takePackage(ticket);
        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_save_in_1st_locker_and_return_ticket_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_5_and_2nd_with_4() {
        Locker firstLocker = new Locker(5, 1);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, new Locker(4, 2)));
        Pack preSavePack = new Pack();

        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        assertTicketNotEmpty(ticket);
        Pack pack = firstLocker.takePackage(ticket);
        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_save_in_2st_locker_and_return_ticket_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_4_and_2nd_with_5() {
        Locker secondLocker = new Locker(5, 2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(4, 1), secondLocker));
        Pack preSavePack = new Pack();

        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        assertTicketNotEmpty(ticket);
        Pack pack = secondLocker.takePackage(ticket);
        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_save_in_2st_locker_and_return_ticket_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_0_and_2nd_with_5() {
        Locker secondLocker = new Locker(5, 2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(0, 1), secondLocker));
        Pack preSavePack = new Pack();

        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        assertTicketNotEmpty(ticket);
        Pack pack = secondLocker.takePackage(ticket);
        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_save_in_1st_locker_and_return_ticket_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_5_and_2nd_with_0() {
        Locker firstLocker = new Locker(5, 1);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, new Locker(0, 2)));
        Pack preSavePack = new Pack();

        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        assertTicketNotEmpty(ticket);
        Pack pack = firstLocker.takePackage(ticket);
        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_throw_locker_full_exception_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_0_and_2nd_with_0() {
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(0, 1), new Locker(0, 2)));
        Pack preSavePack = new Pack();

        LockerFullException exception = assertThrows(
                LockerFullException.class,
                () -> smartLockerRobot.savePackage(preSavePack));
        assertEquals(lockerFullErrorMessage, exception.getMessage());
    }

    @Test
    public void should_take_package_of_ticket_when_take_package_by_smart_locker_robot_given_smart_and_primary_locker_robot_manage_two_lockers_and_get_ticket_by_smart_locker_robot_save_package() {
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(5, 2), new Locker(5, 1)));
        Pack preSavePack = new Pack();
        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        Pack pack = smartLockerRobot.takePackage(new Ticket(ticket.getSerialNo()));

        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_throw_ilLegal_ticket_exception_when_take_package_by_smart_locker_robot_given_smart_and_primary_locker_robot_manage_two_lockers_and_a_fake_ticket() {
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(5, 2), new Locker(5, 1)));

        IlLegalTicketException exception = assertThrows(
                IlLegalTicketException.class,
                () -> smartLockerRobot.takePackage(new Ticket("fake_ticket")));

        assertEquals(ilLegalTicketErrorMessage, exception.getMessage());
    }

    @Test
    public void should_take_package_of_ticket_when_take_package_by_smart_locker_robot_given_smart_and_primary_locker_robot_manage_two_lockers_and_get_ticket_by_primary_locker_robot_save_package() {
        List<Locker> lockers = Arrays.asList(new Locker(5, 2), new Locker(5, 1));
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
        Pack preSavePack = new Pack();
        Ticket ticket = primaryLockerRobot.savePackage(preSavePack);

        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);
        Pack pack = smartLockerRobot.takePackage(new Ticket(ticket.getSerialNo()));

        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_take_package_of_ticket_when_take_package_by_primary_locker_robot_given_smart_and_primary_locker_robot_manage_two_lockers_and_get_ticket_by_smart_locker_robot_save_package() {
        List<Locker> lockers = Arrays.asList(new Locker(5, 2), new Locker(5, 1));
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);
        Pack preSavePack = new Pack();
        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
        Pack pack = primaryLockerRobot.takePackage(new Ticket(ticket.getSerialNo()));

        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_save_in_1st_locker_and_return_ticket_and_1st_locker_is_full_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_1_and_2nd_with_0() {
        Locker firstLocker = new Locker(1, 1);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(0, 2), firstLocker));
        Pack preSavePack = new Pack();

        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        assertTicketNotEmpty(ticket);
        assertTrue(firstLocker.isSaved(new Ticket(ticket.getSerialNo())));
        assertTrue(firstLocker.isFull());
    }

    @Test
    public void should_1st_locker_is_not_full_and_2nd_locker_is_full_when_save_package_then_take_package_by_smart_locker_robot_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_1_and_2nd_with_0() {
        Locker firstLocker = new Locker(1, 1);
        Locker secondLocker = new Locker(0, 2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, secondLocker));

        Ticket ticket = smartLockerRobot.savePackage(new Pack());
        smartLockerRobot.takePackage(new Ticket(ticket.getSerialNo()));

        assertTrue(firstLocker.isNotFull());
        assertTrue(secondLocker.isFull());
    }

    @Test
    public void should_save_in_2st_locker_and_return_ticket_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_2_and_2nd_with_2_and_1st_locker_remaining_1() {
        Locker secondLocker = new Locker(2, 2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(2, 1), secondLocker));
        smartLockerRobot.savePackage(new Pack());
        Pack preSavePack = new Pack();

        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        assertTicketNotEmpty(ticket);
        Pack pack = secondLocker.takePackage(ticket);
        assertEquals(preSavePack, pack);
    }
}