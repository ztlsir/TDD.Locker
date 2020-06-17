package com.ztlsir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Given 储物柜没满 When 存包 Then 获得一张有效票据
Given 储物柜已满 When 存包 Then 提示存包失败
Given 一张有效票据 When 取包 Then 成功取到票据对应的包
Given 一张伪造票据 When 取包 Then 取包失败，提示非法票据
Given 一张已取过包的票据 When 取包 Then 取包失败，提示非法票据
*/
public class LockerTest {

    private static final String savePackageFailedErrorMessage = "存包失败";
    private static final String ilLegalTicketErrorMessage = "非法票据";

    @Test
    public void should_return_ticket_when_save_package_given_locker_is_not_full()
    {
        Locker locker=new Locker(false);
        String ticket=locker.savePackage(new Pack());

        assertNotNull(ticket);
        assertNotEquals("",ticket);
    }

    @Test
    public void should_throw_save_failed_exception_when_save_package_given_locker_is_full()
    {
        Locker locker=new Locker(true);

        Exception exception = assertThrows(
                RuntimeException.class,
                () -> locker.savePackage(new Pack()));

        assertEquals(savePackageFailedErrorMessage, exception.getMessage());
    }

    @Test
    public void should_take_package_of_ticket_when_take_package_given_useful_ticket()
    {
        Locker locker=new Locker(false);
        Pack preSavePack=new Pack();
        String ticket=locker.savePackage(preSavePack);

        Pack pack=locker.takePackage(ticket);

        assertEquals(preSavePack,pack);
    }

    @Test
    public void should_throw_take_failed_exception_when_take_package_given_fake_ticket()
    {
        Locker locker=new Locker(false);

        Exception exception = assertThrows(
                RuntimeException.class,
                () -> locker.takePackage("fake_ticket"));

        assertEquals(ilLegalTicketErrorMessage, exception.getMessage());
    }

    @Test
    public void should_throw_take_failed_exception_when_take_package_given_has_taken_ticket()
    {
        Locker locker=new Locker(false);
        String ticket=locker.savePackage(new Pack());
        locker.takePackage(ticket);

        Exception exception = assertThrows(
                RuntimeException.class,
                () -> locker.takePackage(ticket));

        assertEquals(ilLegalTicketErrorMessage, exception.getMessage());
    }
}
