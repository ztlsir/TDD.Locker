package com.ztlsir.locker;

import com.ztlsir.locker.exception.IllegalTicketException;
import com.ztlsir.locker.exception.LockerFullException;

import java.util.Comparator;
import java.util.List;

public class Lockers {
    private final List<Locker> lockers;

    public Lockers(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Pack take(Ticket ticket) {
        return this.lockers.stream()
                .filter(locker -> locker.isSaved(ticket))
                .findAny()
                .orElseThrow(IllegalTicketException::new)
                .takePackage(ticket);
    }

    public Ticket saveToFirstAvailableLocker(Pack pack) {
        return this.lockers.stream()
                .filter(Locker::isNotFull)
                .findFirst()
                .orElseThrow(LockerFullException::new)
                .savePackage(pack);
    }

    public Ticket saveToMaxRemainingCapacityLocker(Pack pack) {
        return lockers.stream()
                .max(Comparator.comparing(Locker::getRemainingCapacity))
                .get()
                .savePackage(pack);
    }

    public boolean isSaved(Ticket ticket) {
        return this.lockers.stream().anyMatch(locker -> locker.isSaved(ticket));
    }

    public boolean isNotFull() {
        return this.lockers.stream().anyMatch(Locker::isNotFull);
    }
}
