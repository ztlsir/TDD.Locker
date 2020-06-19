package com.ztlsir;

import java.util.HashMap;
import java.util.UUID;

public class Locker {
    private static final String savePackageFailedErrorMessage = "存包失败";
    private static final String ilLegalTicketErrorMessage = "非法票据";

    private boolean isFull;
    private HashMap<Ticket, Pack> tickets;

    public Locker(boolean isFull) {
        this.isFull = isFull;
        this.tickets = new HashMap<Ticket, Pack>();
    }

    public Ticket savePackage(Pack pack) {
        if (this.isFull) {
            throw new RuntimeException(savePackageFailedErrorMessage);
        }

        Ticket ticket = createTicket();
        this.tickets.put(ticket, pack);

        return ticket;
    }

    public Pack takePackage(Ticket ticket) {
        Pack pack = this.tickets.remove(ticket);
        if (pack == null) {
            throw new RuntimeException(ilLegalTicketErrorMessage);
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
        return this.tickets.containsKey(ticket);
    }
}
