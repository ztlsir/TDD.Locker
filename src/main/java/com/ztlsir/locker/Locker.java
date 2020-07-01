package com.ztlsir.locker;

import com.ztlsir.locker.exception.IllegalTicketException;
import com.ztlsir.locker.exception.LockerFullException;

import java.util.HashMap;
import java.util.UUID;

public class Locker {
    private HashMap<Ticket, Pack> packs;
    private int initCapacity;

    public Locker(int capacity) {
        this.initCapacity = capacity;

        this.packs = new HashMap<Ticket, Pack>();
    }

    public Ticket savePackage(Pack pack) {
        if (this.isFull()) {
            throw new LockerFullException();
        }

        Ticket ticket = createTicket();
        this.packs.put(ticket, pack);

        return ticket;
    }

    public Pack takePackage(Ticket ticket) {
        Pack pack = this.packs.remove(ticket);
        if (pack == null) {
            throw new IllegalTicketException();
        }

        return pack;
    }

    boolean isSaved(Ticket ticket) {
        return this.packs.containsKey(ticket);
    }

    int getRemainCapacity() {
        return this.initCapacity - this.packs.size();
    }

    boolean isNotFull() {
        return !this.isFull();
    }

    private boolean isFull() {
        return this.getRemainCapacity() <= 0;
    }

    private Ticket createTicket() {
        return new Ticket(UUID.randomUUID().toString());
    }

    public int getCapacity() {
        return this.initCapacity;
    }

    public Report getReport() {
        return new Report(ReportType.L,this.getRemainCapacity(),this.getCapacity());
    }
}
