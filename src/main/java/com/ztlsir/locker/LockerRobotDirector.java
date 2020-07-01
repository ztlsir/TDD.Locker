package com.ztlsir.locker;

import com.ztlsir.locker.robot.LockerRobotManager;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LockerRobotDirector {
    private final LockerRobotManager lockerRobotManager;

    public LockerRobotDirector(LockerRobotManager manager) {
        this.lockerRobotManager = manager;
    }

    public void printReport() {
        Report managerReport = lockerRobotManager.getReport();
        List<String> strReports = new ArrayList<>();
        strReports.add(getFormatReportStr(managerReport, 0));
        strReports.addAll(managerReport
                .getItemReports()
                .stream()
                .map(report -> getFormatReportStr(report, 1))
                .collect(Collectors.toList()));
        String report = String.join("\r\n", strReports);

        System.out.print(report);
    }

    private String getFormatReportStr(Report manageReport, int indentCount) {
        return MessageFormat.format(
                "{3}{0} {1} {2}",
                manageReport.getType(),
                manageReport.getRemain(),
                manageReport.getCapacity(),
                this.getIndent(indentCount));
    }

    private String getIndent(int count) {
        String indent = "";
        for (int i = 0; i < count; i++) {
            indent += "  ";
        }

        return indent;
    }
}
