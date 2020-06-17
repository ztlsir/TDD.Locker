package com.ztlsir;

import java.util.ArrayList;
import java.util.List;

public class Locker {
    private static final String savePackageFailedErrorMessage = "存包失败";
    private static final String ilLegalTicketErrorMessage = "非法票据";

    private boolean isFull;
    private List<String> tickets;

    public Locker(boolean isFull) {
        this.isFull = isFull;
        this.tickets = new ArrayList<String>();
    }

    public String savePackage() {
        if (this.isFull) {
            throw new RuntimeException(savePackageFailedErrorMessage);
        }

        String ticket = createTicket();
        this.tickets.add(ticket);

        return ticket;
    }

    public void takePackage(String ticket) {
        if (!this.tickets.remove(ticket)) {
            throw new RuntimeException(ilLegalTicketErrorMessage);
        }
    }

    private String createTicket() {
        return "1";
    }
}
