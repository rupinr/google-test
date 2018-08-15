package com.google.test.test;

import com.google.test.reporting.ReportEnhancer;
import com.google.test.reporting.ScreenShotReporter;
import com.google.test.support.TestProperties;
import com.google.test.support.TextHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({ScreenShotReporter.class, ReportEnhancer.class})
public class BaseTest {

    protected static ThreadLocal<BaseStep> stepThreadLocal = new ThreadLocal<>();



    @BeforeMethod
    public void setUp() {
        stepThreadLocal.set(new BaseStep());
    }

    @AfterMethod
    public void tearDown() {
        getTestDriver().getDriver().quit();
    }

    @AfterClass
    public void terminate() {
        //Remove the ThreadLocalMap element
        stepThreadLocal.remove();
    }


    public BaseStep getTestDriver() {
        return stepThreadLocal.get();
    }

}
