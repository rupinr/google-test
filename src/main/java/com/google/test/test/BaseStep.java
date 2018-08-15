package com.google.test.test;

import com.google.test.pages.GoogleHomePage;
import com.google.test.support.TestProperties;
import com.google.test.support.TextHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseStep {

    private WebDriver driver;
    protected TestProperties testProperties;
    protected TextHolder textHolder;


    public BaseStep() {
        testProperties = TestProperties.getInstance();
        textHolder = TextHolder.getInstance();
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


}
