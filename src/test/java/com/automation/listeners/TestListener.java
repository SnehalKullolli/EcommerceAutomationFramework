package com.automation.listeners;

import com.automation.base.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentManager;
import utils.ScreenshotUtility;

public class TestListener implements ITestListener {

    private static ExtentReports extent =
            ExtentManager.getReport();

    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	

        test.get().fail(result.getThrowable());

        String screenshotPath =
                ScreenshotUtility.capture(
                        DriverFactory.getDriver(),
                        result.getName()
                );

        test.get().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}