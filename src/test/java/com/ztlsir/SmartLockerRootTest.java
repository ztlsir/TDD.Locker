package com.ztlsir;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.ztlsir.fixture.LockerFixture.assertTicketNotEmpty;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜空余量为5，第2个储物柜空余量为5 When 存包 Then 获得一张有效票据，包存到第1个储物柜
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜空余量为5，第2个储物柜空余量为4 When 存包 Then 获得一张有效票据，包存到第1个储物柜
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜空余量为4，第2个储物柜空余量为5 When 存包 Then 获得一张有效票据，包存到第2个储物柜
 * Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜空余量为0，第2个储物柜空余量为5 When 存包 Then 获得一张有效票据，包存到第2个储物柜
 * todo Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜空余量为5，第2个储物柜空余量为0 When 存包 Then 获得一张有效票据，包存到第1个储物柜
 * todo Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，第1个储物柜空余量为0，第2个储物柜空余量为0 When 存包 Then 存包失败，提示储物柜已满
 * todo Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，通过SmartLockerRoot存包取得的一张有效票据 When 通过SmartLockerRoot取包 Then 取包成功
 * todo Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，一张伪造票据 When 通过SmartLockerRoot取包 Then 取包失败，提示非法票据
 * todo Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，通过PrimaryLockerRoot存包取得的一张有效票据 When 通过SmartLockerRoot取包 Then 取包成功
 * todo Given SmartLockerRoot和PrimaryLockerRoot共同管理2个储物柜，通过SmartLockerRoot存包取得的一张有效票据 When 通过PrimaryLockerRoot取包 Then 取包成功
 */
public class SmartLockerRootTest {
    @Test
    public void should_save_in_1st_locker_and_return_ticket_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_5_and_2nd_with_5() {
        Locker firstLocker = new Locker(5, 1);
        SmartLockerRoot smartLockerRoot = new SmartLockerRoot(Arrays.asList(new Locker(5, 2), firstLocker));
        Pack preSavePack = new Pack();

        Ticket ticket = smartLockerRoot.savePackage(preSavePack);

        assertTicketNotEmpty(ticket);
        Pack pack = firstLocker.takePackage(ticket);
        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_save_in_1st_locker_and_return_ticket_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_5_and_2nd_with_4() {
        Locker firstLocker = new Locker(5, 1);
        SmartLockerRoot smartLockerRoot = new SmartLockerRoot(Arrays.asList(firstLocker, new Locker(4, 2)));
        Pack preSavePack = new Pack();

        Ticket ticket = smartLockerRoot.savePackage(preSavePack);

        assertTicketNotEmpty(ticket);
        Pack pack = firstLocker.takePackage(ticket);
        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_save_in_2st_locker_and_return_ticket_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_4_and_2nd_with_5() {
        Locker secondLocker = new Locker(5, 2);
        SmartLockerRoot smartLockerRoot = new SmartLockerRoot(Arrays.asList(new Locker(4, 1), secondLocker));
        Pack preSavePack = new Pack();

        Ticket ticket = smartLockerRoot.savePackage(preSavePack);

        assertTicketNotEmpty(ticket);
        Pack pack = secondLocker.takePackage(ticket);
        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_save_in_2st_locker_and_return_ticket_when_save_package_given_smart_and_primary_locker_robot_manage_two_lockers_and_1st_locker_with_0_and_2nd_with_5() {
        Locker secondLocker = new Locker(5, 2);
        SmartLockerRoot smartLockerRoot = new SmartLockerRoot(Arrays.asList(new Locker(0, 1), secondLocker));
        Pack preSavePack = new Pack();

        Ticket ticket = smartLockerRoot.savePackage(preSavePack);

        assertTicketNotEmpty(ticket);
        Pack pack = secondLocker.takePackage(ticket);
        assertEquals(preSavePack, pack);
    }
}
