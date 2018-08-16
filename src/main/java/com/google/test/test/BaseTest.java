package com.google.test.test;

import com.google.test.reporting.ReportEnhancer;
import com.google.test.reporting.ScreenShotReporter;
import com.google.test.support.TestProperties;
import com.google.test.support.TextHolder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({ScreenShotReporter.class, ReportEnhancer.class})
public class BaseTest {

    private static ThreadLocal<BaseStep> stepThreadLocal = new ThreadLocal<>();
    protected static TestProperties testProperties = TestProperties.getInstance();
    protected static TextHolder textHolder = TextHolder.getInstance();


    @BeforeMethod
    public void setUp() {
        stepThreadLocal.set(new BaseStep());
    }

    @AfterMethod
    public void tearDown() {
        getTestDriver().getDriver().quit();
    }

    @AfterSuite
    public void terminate() {
        stepThreadLocal.remove();
    }


    public BaseStep getTestDriver() {
        return stepThreadLocal.get();
    }

}
