package com.google.test;

import com.google.test.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void test(){
        this.getTestDriver()
                .openGoogleHomePage()
                .editSearchText("xxxxxxxxxxxxxxxxxxxx")
                .openGoogleSearchResultPage();
        

    }

    @Test
    public void test2(){
        this.getTestDriver()
                .openGoogleHomePage()
                .editSearchText("yyyyyyyyyyyyyyyyy")
                .openGoogleSearchResultPage();


    }

//    @AfterMethod
//    public void tearDown(){
//        this.getDriver().quit();
//    }
}
