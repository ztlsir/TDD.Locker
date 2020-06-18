package com.ztlsir;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
* Given 机器人管理2个储物柜，2个储物柜都没满 When 存包 Then 获得一张有效票据，包存到第1个储物柜
*todo Given 机器人管理2个储物柜，第1个储物柜已满，第2个储物柜未满 When 存包 Then 获得一张有效票据，包存到第2个储物柜
*todo Given 机器人管理2个储物柜，第1个储物柜未满，第2个储物柜已满 When 存包 Then 获得一张有效票据，包存到第1个储物柜
*todo Given 机器人管理2个储物柜，2个储物柜都已满 When 存包 Then 提示存包失败
*todo Given 一张有效票据 When 取包 Then 取包成功
*todo Given 一张伪造票据 When 取包 Then 取包失败，提示非法票据
*todo Given 一张已取过包的票据 When 取包 Then 取包失败，提示非法票据
* */
public class PrimaryLockerRobotTest {
    @Test
    public void should_save_in_1st_locker_and_return_ticket_when_save_package_given_robot_manage_two_lockers_and_both_is_not_full()
    {
        Locker firstLocker=new Locker(false);
        PrimaryLockerRobot primaryLockerRobot=new PrimaryLockerRobot(Arrays.asList(firstLocker,new Locker(false)));
        Pack preSavePack=new Pack();

        String ticket=primaryLockerRobot.savePackage(preSavePack);

        assertNotNull(ticket);
        assertNotEquals("",ticket);
        Pack pack=firstLocker.takePackage(ticket);
        assertEquals(preSavePack,pack);
    }
}
