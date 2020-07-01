package com.ztlsir.locker;

import java.util.List;

public class Report {
    private String type;
    private int remain;
    private int capacity;
    private List<Report> itemReports;

    public Report(String type, int remain, int capacity) {
        this.type = type;
        this.remain = remain;
        this.capacity = capacity;
    }

    public Report(String type, int remain, int capacity, List<Report> itemReports) {
        this.type = type;
        this.remain = remain;
        this.capacity = capacity;
        this.itemReports = itemReports;
    }

    public String getType() {
        return type;
    }

    public int getRemain() {
        return remain;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Report> getItemReports() {
        return this.itemReports;
    }
}
