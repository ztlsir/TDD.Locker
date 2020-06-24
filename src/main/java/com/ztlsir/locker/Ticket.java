package com.ztlsir.locker;

import java.util.Objects;

public class Ticket {
    private String serialNo;

    public Ticket(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getSerialNo() {
        return this.serialNo;
    }

    @Override
    public boolean equals(Object anTicket) {
        if (anTicket instanceof Ticket) {
            return this.equals((Ticket) anTicket);
        }

        return false;
    }

    private boolean equals(Ticket anTicket) {
        if (this == anTicket) {
            return true;
        }

        return Objects.equals(this.serialNo, anTicket.serialNo);

    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $serialNo = this.getSerialNo();
        result = result * PRIME + ($serialNo == null ? 43 : $serialNo.hashCode());
        return result;
    }
}