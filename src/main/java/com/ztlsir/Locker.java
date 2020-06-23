package com.ztlsir;

import com.ztlsir.exception.IlLegalTicketException;
import com.ztlsir.exception.LockerFullException;

import java.util.HashMap;
import java.util.UUID;

public class Locker {
    private HashMap<Ticket, Pack> packs;
    private int initCapacity;
    private int order;

    public Locker(int capacity) {
        this(capacity, 0);
    }

    public Locker(int capacity, int order) {
        this.initCapacity = capacity;
        this.order = order;

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
            throw new IlLegalTicketException();
        }

        return pack;
    }

    public boolean isFull() {
        return this.getRemainingCapacity() <= 0;
    }

    public int getRemainingCapacity() {
        return this.initCapacity - this.packs.size();
    }

    public boolean isNotFull() {
        return !this.isFull();
    }

    private Ticket createTicket() {
        return new Ticket(UUID.randomUUID().toString());
    }

    public boolean isSaved(Ticket ticket) {
        return this.packs.containsKey(ticket);
    }

    public int getOrder() {
        return this.order;
    }
}
