package com.ztlsir.locker.robot;

import com.ztlsir.locker.Locker;
import com.ztlsir.locker.Pack;
import com.ztlsir.locker.Ticket;
import com.ztlsir.locker.fixture.LockerAssertFixture;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.ztlsir.locker.fixture.LockerRobotAssertFixture.assertThrowIllegalTicketExceptionWhileTakePackage;
import static com.ztlsir.locker.fixture.LockerRobotAssertFixture.assertThrowLockerFullExceptionWhileSavePackage;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜余量为5，第2个储物柜余量为5 When 存包 Then 获得一张有效票据，包存到第1个储物柜
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜余量为5，第2个储物柜余量为4 When 存包 Then 获得一张有效票据，包存到第1个储物柜
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜余量为4，第2个储物柜余量为5 When 存包 Then 获得一张有效票据，包存到第2个储物柜
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜余量为0，第2个储物柜余量为5 When 存包 Then 获得一张有效票据，包存到第2个储物柜
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜余量为5，第2个储物柜余量为0 When 存包 Then 获得一张有效票据，包存到第1个储物柜
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜余量为0，第2个储物柜余量为0 When 存包 Then 存包失败，提示储物柜已满
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，通过SmartLockerRoot存包取得的一张有效票据 When 通过SmartLockerRoot取包 Then 取包成功
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，一张伪造票据 When 通过SmartLockerRoot取包 Then 取包失败，提示非法票据
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，通过PrimaryLockerRoot存包取得的一张有效票据 When 通过SmartLockerRoot取包 Then 取包成功
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，通过SmartLockerRoot存包取得的一张有效票据 When 通过PrimaryLockerRoot取包 Then 取包成功
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为1，余量为0，第2个储物柜余量为0 When 存包 Then 存包失败，提示储物柜已满
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜余量为0，第2个储物柜余量为0，一张包存在第一个储物柜的票据 When 取包，再存包 Then 获得一张有效票据，包存到第1个储物柜
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜容量为2,余量为1，第2个储物柜容量为2 When 存包 Then 获得一张有效票据，包存到第2个储物柜
 * Given SmartLockerRoot管理着0个储物柜 When 存包 Then 存包失败，提示储物柜已满
 */
public class SmartLockerRobotTest {
    @Test
    public void should_save_in_1st_locker_and_return_ticket_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_5_and_2nd_with_5() {
        Locker firstLocker = new Locker(5);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, new Locker(5)));
        Pack preSavePack = new Pack();

        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        LockerAssertFixture.assertTicketAndPackSavedLocker(firstLocker, preSavePack, ticket);
    }

    @Test
    public void should_save_in_1st_locker_and_return_ticket_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_5_and_2nd_with_4() {
        Locker firstLocker = new Locker(5);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, new Locker(4)));
        Pack preSavePack = new Pack();

        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        LockerAssertFixture.assertTicketAndPackSavedLocker(firstLocker, preSavePack, ticket);
    }

    @Test
    public void should_save_in_2st_locker_and_return_ticket_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_4_and_2nd_with_5() {
        Locker secondLocker = new Locker(5);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(4), secondLocker));
        Pack preSavePack = new Pack();

        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        LockerAssertFixture.assertTicketAndPackSavedLocker(secondLocker, preSavePack, ticket);
    }

    @Test
    public void should_save_in_2st_locker_and_return_ticket_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_0_and_2nd_with_5() {
        Locker secondLocker = new Locker(5);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(0), secondLocker));
        Pack preSavePack = new Pack();

        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        LockerAssertFixture.assertTicketAndPackSavedLocker(secondLocker, preSavePack, ticket);
    }

    @Test
    public void should_save_in_1st_locker_and_return_ticket_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_5_and_2nd_with_0() {
        Locker firstLocker = new Locker(5);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, new Locker(0)));
        Pack preSavePack = new Pack();

        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        LockerAssertFixture.assertTicketAndPackSavedLocker(firstLocker, preSavePack, ticket);
    }

    @Test
    public void should_throw_locker_full_exception_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_0_and_2nd_with_0() {
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(0), new Locker(0)));
        Pack preSavePack = new Pack();

        assertThrowLockerFullExceptionWhileSavePackage(smartLockerRobot, preSavePack);
    }

    @Test
    public void should_take_package_of_ticket_when_take_package_by_smart_locker_robot_given_smart_and_primary_locker_robot_manage_two_lockers_and_get_ticket_by_smart_locker_robot_save_package() {
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(5), new Locker(5)));
        Pack preSavePack = new Pack();
        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        Pack pack = smartLockerRobot.takePackage(new Ticket(ticket.getSerialNo()));

        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_throw_ilLegal_ticket_exception_when_take_package_by_smart_locker_robot_given_smart_and_primary_locker_robot_manage_two_lockers_and_a_fake_ticket() {
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(5), new Locker(5)));

        assertThrowIllegalTicketExceptionWhileTakePackage(smartLockerRobot, "fake_ticket");
    }

    @Test
    public void should_take_package_of_ticket_when_take_package_by_smart_locker_robot_given_smart_and_primary_locker_robot_manage_two_lockers_and_get_ticket_by_primary_locker_robot_save_package() {
        List<Locker> lockers = Arrays.asList(new Locker(5), new Locker(5));
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
        Pack preSavePack = new Pack();
        Ticket ticket = primaryLockerRobot.savePackage(preSavePack);

        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);
        Pack pack = smartLockerRobot.takePackage(new Ticket(ticket.getSerialNo()));

        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_take_package_of_ticket_when_take_package_by_primary_locker_robot_given_smart_and_primary_locker_robot_manage_two_lockers_and_get_ticket_by_smart_locker_robot_save_package() {
        List<Locker> lockers = Arrays.asList(new Locker(5), new Locker(5));
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockers);
        Pack preSavePack = new Pack();
        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(lockers);
        Pack pack = primaryLockerRobot.takePackage(new Ticket(ticket.getSerialNo()));

        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_throw_locker_full_exception_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_1_remaining_0_and_2nd_with_0() {
        Locker firstLocker = new Locker(1);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(0), firstLocker));
        smartLockerRobot.savePackage(new Pack());

        assertThrowLockerFullExceptionWhileSavePackage(smartLockerRobot, new Pack());
    }

    @Test
    public void should_save_in_1st_locker_and_return_ticket_when_take_package_then_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_1_and_2nd_with_0_and_one_ticket_that_package_save_in_1st_locker() {
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(0);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(firstLocker, secondLocker));
        Ticket givenTicket = smartLockerRobot.savePackage(new Pack());

        smartLockerRobot.takePackage(new Ticket(givenTicket.getSerialNo()));
        Pack preSavePack = new Pack();
        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        LockerAssertFixture.assertTicketAndPackSavedLocker(firstLocker, preSavePack, ticket);
    }

    @Test
    public void should_save_in_2st_locker_and_return_ticket_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_2_and_2nd_with_2_and_1st_locker_remaining_1() {
        Locker secondLocker = new Locker(2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(Arrays.asList(new Locker(2), secondLocker));
        smartLockerRobot.savePackage(new Pack());
        Pack preSavePack = new Pack();

        Ticket ticket = smartLockerRobot.savePackage(preSavePack);

        LockerAssertFixture.assertTicketAndPackSavedLocker(secondLocker, preSavePack, ticket);
    }

    @Test
    public void should_throw_locker_full_exception_when_save_package_given_smart_locker_robot_manage_0_lockers() {
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(new ArrayList<>());

        assertThrowLockerFullExceptionWhileSavePackage(smartLockerRobot,new Pack());
    }
}