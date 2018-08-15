package com.google.test.reporting;

import com.google.test.support.TestProperties;
import com.google.test.test.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ScreenShotReporter implements ITestListener {

    private TestProperties testProperties = TestProperties.getInstance();


    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        if (testProperties.getTakeScreenShot()) {
            WebDriver driver = extractWebDriver(iTestResult);
            if(driver==null){
                Reporter.log("Driver is not initialized. Unable to capture screenshot");
            }
            String fileName = UUID.randomUUID().toString();
            try {
                File resultFile=new File(testProperties.getScreenshotDirectory() + "/" + fileName + ".png");
                FileUtils.copyFile(this.takeScreenShot(driver), resultFile);
                String path = "<img height=\"50%\" width=\"50%\" src=\"file://" + resultFile.getAbsolutePath() + "\" alt=\"Screenshot\"/>";
                Reporter.log(path);
            } catch ( IOException e ) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }

    private File takeScreenShot(WebDriver driver) {
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
        return screenshotDriver.getScreenshotAs(OutputType.FILE);
    }

    private WebDriver extractWebDriver(ITestResult result) {
        BaseTest baseTest = (BaseTest) (result.getInstance());
        return baseTest.getDriver();
    }

}
