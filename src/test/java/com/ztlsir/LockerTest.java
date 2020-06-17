package com.ztlsir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Given 储物柜没满 When 存包 Then 获得一张有效票据
Given 储物柜已满 When 存包 Then 提示存包失败
Given 一张有效票据 When 取包 Then 取包成功
todo:Given 一张伪造票据 When 取包 Then 取包失败，提示非法票据
todo:Given 一张已取过包的票据 When 取包 Then 取包失败，提示非法票据
*/
public class LockerTest {

    public static final String savePackageFailedErrorMessage = "存包失败";

    @Test
    public void should_return_ticket_when_save_package_given_locker_is_not_full()
    {
        Locker locker=new Locker(false);

        String ticket=locker.savePackage();

        assertNotNull(ticket);
        assertNotEquals("",ticket);
    }

    @Test
    public void should_throw_save_failed_exception_when_save_package_given_locker_is_full()
    {
        Locker locker=new Locker(true);

        Exception exception = assertThrows(
                RuntimeException.class,
                () -> locker.savePackage());

        assertEquals(savePackageFailedErrorMessage, exception.getMessage());
    }

    @Test
    public void should_be_success_when_take_package_given_useful_ticket()
    {
        Locker locker=new Locker(false);
        String ticket=locker.savePackage();

        boolean isSuccess=locker.takePackage(ticket);

        assertTrue(isSuccess);
    }
}
