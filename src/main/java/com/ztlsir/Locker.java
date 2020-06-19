package com.ztlsir;

import com.ztlsir.exception.IlLegalTicketException;
import com.ztlsir.exception.LockerFullException;

import java.util.HashMap;
import java.util.UUID;

public class Locker {
    private boolean isFull;
    private HashMap<Ticket, Pack> packs;

    public Locker(boolean isFull) {
        this.isFull = isFull;
        this.packs = new HashMap<Ticket, Pack>();
    }

    public Locker(int capacity) {
        this.packs = new HashMap<Ticket, Pack>();
    }

    public Ticket savePackage(Pack pack) {
        if (this.isFull) {
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

    private Ticket createTicket() {
        return new Ticket(UUID.randomUUID().toString());
    }

    public boolean isNotFull() {
        return !this.isFull;
    }

    public boolean isSaved(Ticket ticket) {
        return this.packs.containsKey(ticket);
    }
}
