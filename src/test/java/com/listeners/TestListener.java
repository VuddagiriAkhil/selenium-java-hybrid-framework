
package com.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.utils.ExtentManager;
import com.utils.ScreenshotUtils;
import com.driver.DriverFactory;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final ThreadLocal<ExtentTest> TEST =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = ExtentManager.getInstance()
                .createTest(result.getMethod().getMethodName());

        TEST.set(test);
        test.info("Test execution started");
        System.out.println("TEST STARTED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        TEST.get().pass("Test passed successfully");
        System.out.println("TEST PASSED: " + result.getName());
        TEST.remove();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        TEST.get().fail(result.getThrowable());
        System.out.println("TEST FAILED: " + result.getName());

        try {
            String path = ScreenshotUtils.captureScreenshot(
                    DriverFactory.getDriver(), result.getName());

            TEST.get().addScreenCaptureFromPath(path);
            System.out.println("Screenshot saved: " + path);

        } catch (Exception e) {
            TEST.get().warning(
                    "Screenshot capture failed: " + e.getMessage());
        } finally {
            TEST.remove();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if (TEST.get() != null) {
            TEST.get().skip("Test skipped");
            TEST.remove();
        }
        System.out.println("TEST SKIPPED: " + result.getName());
    }

    @Override
    public void onFinish(
            org.testng.ITestContext context) {
        ExtentManager.getInstance().flush();
    }
}
