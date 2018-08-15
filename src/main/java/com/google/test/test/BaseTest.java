package com.google.test.test;

import com.google.test.reporting.ReportEnhancer;
import com.google.test.reporting.ScreenShotReporter;
import com.google.test.support.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

@Listeners({ScreenShotReporter.class, ReportEnhancer.class})
public class BaseTest {

    protected TestProperties testProperties;
    private WebDriver driver;

    public BaseTest() {
        testProperties = TestProperties.getInstance();
    }

    public BaseTest openBrowser() {
        driver = createWebDriver();
        return this;
    }


    private WebDriver createWebDriver() {
        String browserName = testProperties.getBrowser();
        WebDriver driver = null;
        switch (browserName) {
            case "chrome":
                driver = createChromeDriver();
                break;
            case "firefox":
                driver = createFireFoxDriver();
                break;

        }
        return driver;
    }


    private WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", testProperties.getChromeDriverPath());
        return new ChromeDriver();
    }

    private WebDriver createFireFoxDriver() {
        System.setProperty("webdriver.gecko.driver", testProperties.getGekhoDriverPath());
        return new FirefoxDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
