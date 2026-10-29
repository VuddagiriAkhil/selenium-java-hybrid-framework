package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentManager {

    private static final ExtentReports EXTENT = createReport();

    private ExtentManager() {
    }

    private static ExtentReports createReport() {
        ExtentSparkReporter reporter =
                new ExtentSparkReporter("test-output/ExtentReport.html");

        ExtentReports reports = new ExtentReports();
        reports.attachReporter(reporter);
        reports.setSystemInfo("Framework", "Selenium Java Hybrid");
        reports.setSystemInfo("Browser", "Chrome");

        return reports;
    }

    public static ExtentReports getInstance() {
        return EXTENT;
    }
}