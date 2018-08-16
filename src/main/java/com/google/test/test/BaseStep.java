package com.google.test.test;

import com.google.test.pages.GoogleHomePage;
import com.google.test.support.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseStep {

    private WebDriver driver;


    public BaseStep() {
        this.driver = this.createWebDriver();

    }

    public GoogleHomePage openGoogleHomePage() {
        this.driver.get(TestProperties.getInstance().getHomePageURL());
        return new GoogleHomePage(driver);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    private WebDriver createWebDriver() {
        String browserName = BaseTest.testProperties.getBrowser();
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
        System.setProperty("webdriver.chrome.driver", BaseTest.testProperties.getChromeDriverPath());
        return new ChromeDriver();
    }

    private WebDriver createFireFoxDriver() {
        System.setProperty("webdriver.gecko.driver", BaseTest.testProperties.getGekhoDriverPath());
        return new FirefoxDriver();
    }


}
