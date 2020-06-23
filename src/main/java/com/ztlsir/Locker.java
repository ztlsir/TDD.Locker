package com.ztlsir;

import com.ztlsir.exception.IllegalTicketException;
import com.ztlsir.exception.LockerFullException;

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

    public boolean isSaved(Ticket ticket) {
        return this.packs.containsKey(ticket);
    }

    public int getRemainingCapacity() {
        return this.initCapacity - this.packs.size();
    }

    protected boolean isNotFull() {
        return !this.isFull();
    }

    private boolean isFull() {
        return this.getRemainingCapacity() <= 0;
    }

    private Ticket createTicket() {
        return new Ticket(UUID.randomUUID().toString());
    }
}
