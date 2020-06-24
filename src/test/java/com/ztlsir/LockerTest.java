package com.ztlsir;

import com.ztlsir.exception.IllegalTicketException;
import org.junit.jupiter.api.Test;

import static com.ztlsir.fixture.LockerAssertFixture.*;
import static com.ztlsir.fixture.LockerCreatorFixture.createAvailableLocker;
import static com.ztlsir.fixture.LockerCreatorFixture.createFullLocker;
import static org.junit.jupiter.api.Assertions.*;

/*
Given 储物柜没满 When 存包 Then 获得一张有效票据
Given 储物柜已满 When 存包 Then 存包失败，提示储物柜已满
Given 一张有效票据 When 取包 Then 成功取到票据对应的包
Given 一张伪造票据 When 取包 Then 取包失败，提示非法票据
Given 一张已取过包的票据 When 取包 Then 取包失败，提示非法票据
Given 储物柜没满 When 连续存两个不同的包 Then 获得两张有效票据
Given 两张有效票据 When 取包 Then 成功取到每张票据对应的包
*/
public class LockerTest {
    @Test
    public void should_return_ticket_when_save_package_given_locker_is_not_full() {
        Locker locker = createAvailableLocker();

        Ticket ticket = locker.savePackage(new Pack());

        assertTicketNotEmpty(ticket);
    }

    @Test
    public void should_throw_locker_full_exception_when_save_package_given_locker_is_full() {
        Locker locker = createFullLocker();

        assertThrowLockerFullException(() -> locker.savePackage(new Pack()));
    }

    @Test
    public void should_take_package_by_ticket_when_take_package_given_useful_ticket() {
        Locker locker = createAvailableLocker();
        Pack preSavePack = new Pack();
        Ticket ticket = locker.savePackage(preSavePack);

        Pack pack = locker.takePackage(new Ticket(ticket.getSerialNo()));

        assertEquals(preSavePack, pack);
    }

    @Test
    public void should_throw_ilLegal_ticket_exception_when_take_package_given_fake_ticket() {
        Locker locker = createAvailableLocker();

        assertThrowIllegalTicketException(() -> locker.takePackage(new Ticket("fake_ticket")));

    }

    @Test
    public void should_throw_ilLegal_ticket_exception_when_take_package_given_has_taken_ticket() {
        Locker locker = createAvailableLocker();
        Ticket ticket = locker.savePackage(new Pack());
        locker.takePackage(new Ticket(ticket.getSerialNo()));

        assertThrowIllegalTicketException(() -> locker.takePackage(new Ticket(ticket.getSerialNo())));
    }

    @Test
    public void should_return_two_ticket_when_save_two_package_given_locker_is_not_full() {
        Locker locker = createAvailableLocker();

        Ticket firstTicket = locker.savePackage(new Pack());
        Ticket secondTicket = locker.savePackage(new Pack());

        assertTicketNotEmpty(firstTicket);
        assertTicketNotEmpty(secondTicket);
        assertNotEquals(firstTicket, secondTicket);
    }

    @Test
    public void should_take_two_package_by_two_ticket_when_take_package_given_two_ticket_is_valid() {
        Locker locker = createAvailableLocker();
        Pack firstPreSavePack = new Pack();
        Ticket firstTicket = locker.savePackage(firstPreSavePack);
        Pack secondPreSavePack = new Pack();
        Ticket secondTicket = locker.savePackage(secondPreSavePack);

        Pack firstPack = locker.takePackage(new Ticket(firstTicket.getSerialNo()));
        Pack secondPack = locker.takePackage(new Ticket(secondTicket.getSerialNo()));

        assertEquals(firstPreSavePack, firstPack);
        assertEquals(secondPreSavePack, secondPack);
        assertNotEquals(firstPack, secondPack);
    }
}
