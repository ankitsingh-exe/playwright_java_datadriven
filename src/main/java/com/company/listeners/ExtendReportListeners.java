package com.company.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.microsoft.playwright.Page;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

import static com.company.factory.PlaywrightFactory.getPage;

public class ExtendReportListeners implements ITestListener {

    private static final String OUTPUT_FOLDER = "./build";
    private static final String FILE_NAME = "./TestExecutionReport.html";

    private static ExtentReports extentReports = init();

    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    private static ExtentReports init(){
        Path path = Paths.get(OUTPUT_FOLDER);
        if (!Files.exists(path)){
            try {
                Files.createDirectories(path);
            }catch (IOException ioException){
                ioException.printStackTrace();
            }
        }

        extentReports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
        reporter.config().setReportName("Open Cart Automation Test Result");

        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("System", "Windows");
        extentReports.setSystemInfo("Auther", "Ankit");
        extentReports.setSystemInfo("Build#", "1.1");
        extentReports.setSystemInfo("Team", "OMS");

        return extentReports;
    }


    private Date getTime(long miliseconds){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(miliseconds);
        return calendar.getTime();
    }


    public static String takeScreenshot(){
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        getPage().screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(path))
                .setFullPage(true));
        return path;
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Tha name of test case starting is " + result.getTestName());
        ExtentTest extentTest = extentReports.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        extentTestThreadLocal.set(extentTest);
        extentTestThreadLocal.get().getModel().setStartTime(getTime(result.getStartMillis()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Tha name of test case passing is " + result.getTestName());
        extentTestThreadLocal.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Tha name of test case failing is " + result.getTestName());
        extentTestThreadLocal.get().fail(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        extentTestThreadLocal.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Tha name of test case failing is " + result.getTestName());
        extentTestThreadLocal.get().fail(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        extentTestThreadLocal.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        //ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
