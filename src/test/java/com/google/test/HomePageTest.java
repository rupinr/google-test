package com.google.test;

import com.google.test.test.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void test(){
        this.openBrowser().getDriver().get("http://google.com");

    }

    @AfterTest
    public void tearDown(){
        this.getDriver().quit();
    }
}
