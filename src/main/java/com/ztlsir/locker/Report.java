package com.ztlsir.locker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

public class Report {
    private final ReportType type;
    private final int remain;
    private final int capacity;
    private final List<Report> itemReports;

    public Report(ReportType type, int remain, int capacity) {
        this.type = type;
        this.remain = remain;
        this.capacity = capacity;
        this.itemReports = new ArrayList<>();
    }

    public Report(ReportType type, List<Report> itemReports) {
        this.type = type;
        this.itemReports = itemReports;

        this.remain = this.getElementSumByItemReports(Report::getRemain);
        this.capacity = this.getElementSumByItemReports(Report::getCapacity);
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

    private int getElementSumByItemReports(ToIntFunction<Report> mapper) {
        return this.getItemReports().stream().mapToInt(mapper).sum();
    }
}
