package com.ztlsir.locker;

import com.ztlsir.locker.robot.LockerRobotManager;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LockerRobotDirector {
    private static final String REPORT_FORMAT_STRING = "{0}{1} {2} {3}";
    private static final int INDENT_INCREASE_SIZE = 1;
    private static final String LINE_BREAK = "\r\n";
    private static final String SINGLE_INDENT_STR = "  ";
    private static final int INIT_INDENT_COUNT = 0;

    private final List<LockerRobotManager> lockerRobotManagers;

    public LockerRobotDirector(List<LockerRobotManager> managers) {
        this.lockerRobotManagers = managers;
    }

    public void printReport() {
        List<String> strReports = new ArrayList<>();
        AppendReportsToStrReports(
                strReports,
                lockerRobotManagers.stream()
                        .map(lockerRobotManager -> lockerRobotManager.getReport())
                        .collect(Collectors.toList()),
                INIT_INDENT_COUNT);

        String report = String.join(LINE_BREAK, strReports);
        System.out.print(report);
    }

    private void AppendReportsToStrReports(List<String> strReports, List<Report> reports, int indentCount) {
        reports.forEach(report -> {
            strReports.add(getFormatReportStr(report, indentCount));
            if (report.getType() != ReportType.L) {
                AppendReportsToStrReports(strReports, report.getItemReports(), indentCount + INDENT_INCREASE_SIZE);
            }
        });
    }

    private String getFormatReportStr(Report manageReport, int indentCount) {
        return MessageFormat.format(
                REPORT_FORMAT_STRING,
                this.getIndentStr(indentCount),
                manageReport.getType(),
                manageReport.getRemain(),
                manageReport.getCapacity());
    }

    private String getIndentStr(int count) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < count; i++) {
            indent.append(SINGLE_INDENT_STR);
        }

        return indent.toString();
    }
}
