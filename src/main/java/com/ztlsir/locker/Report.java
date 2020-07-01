package com.ztlsir.locker;

import java.util.List;

public class Report {
    private ReportType type;
    private int remain;
    private int capacity;
    private List<Report> itemReports;

    public Report(ReportType type, int remain, int capacity) {
        this.type = type;
        this.remain = remain;
        this.capacity = capacity;
    }

    public Report(ReportType type, int remain, int capacity, List<Report> itemReports) {
        this.type = type;
        this.remain = remain;
        this.capacity = capacity;
        this.itemReports = itemReports;
    }

    public ReportType getType() {
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
