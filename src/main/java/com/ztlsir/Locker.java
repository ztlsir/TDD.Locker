package com.ztlsir;

import java.util.HashMap;

public class Locker {
    private static final String savePackageFailedErrorMessage = "存包失败";
    private static final String ilLegalTicketErrorMessage = "非法票据";

    private boolean isFull;
    private HashMap<String, Pack> tickets;

    public Locker(boolean isFull) {
        this.isFull = isFull;
        this.tickets = new HashMap<String, Pack>();
    }

    public String savePackage(Pack pack) {
        if (this.isFull) {
            throw new RuntimeException(savePackageFailedErrorMessage);
        }

        String ticket = createTicket();
        this.tickets.put(ticket, pack);

        return ticket;
    }

    public Pack takePackage(String ticket) {
        Pack pack = this.tickets.remove(ticket);
        if (pack == null) {
            throw new RuntimeException(ilLegalTicketErrorMessage);
        }

        return pack;
    }

    private String createTicket() {
        return "1";
    }

    public boolean isNotFull() {
        return !this.isFull;
    }
}
