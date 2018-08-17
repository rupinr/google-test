package com.google.test.pages;

import com.google.test.component.BaseActionEditor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleAppsMenu extends BasePage {

    private static final String ACCOUNT_XPATH = "//*[@data-pid=192]";
    private static final String SEARCH_XPATH = "//*[@data-pid=1]";
    private static final String MAPS_XPATH = "//*[@data-pid=8]";
    private static final String YOUTUBE_XPATH = "//*[@data-pid=36]";
    private static final String PLAY_XPATH = "//*[@data-pid=78]";
    private static final String GMAIL_XPATH = "//*[@data-pid=23]";
    private static final String CONTACTS_XPATH = "//*[@data-pid=53]";
    private static final String DRIVE_XPATH = "//*[@data-pid=49]";
    private static final String CALENDAR_XPATH = "//*[@data-pid=24]";
    private static final String TRANSLATE_XPATH = "//*[@data-pid=51]";
    private static final String PHOTOS_XPATH = "//*[@data-pid=31]";
    private static final String DOCS_XPATH = "//*[@data-pid=25]";
    private static final String BOOKS_XPATH = "//*[@data-pid=10]";
    private static final String BLOGGER_XPATH = "//*[@data-pid=30]";
    private static final String HANGOUTS_XPATH = "//*[@data-pid=300]";
    private static final String KEEP_XPATH = "//*[@data-pid=136]";
    private static final String EARTH_XPATH = "//*[@data-pid=429]";

    private static final String MORE_XPATH = "//*[@class='gb_ea gb_5f']";

    private BaseActionEditor actionEditor;

    public GoogleAppsMenu(WebDriver driver) {
        super(driver);
        actionEditor = new BaseActionEditor(driver);
    }

    public GoogleAppsMenu clickOnMoreButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(MORE_XPATH))));
        actionEditor.clickOnElementByXpath(MORE_XPATH);
        return this;
    }


    public String getHangoutAppText() {
        return getText(HANGOUTS_XPATH);
    }

    public String getKeepAppText() {
        return getText(KEEP_XPATH);
    }


    public String getEarthAppText() {
        return getText(EARTH_XPATH);
    }

    public String getAccountAppText() {
        return getText(ACCOUNT_XPATH);
    }

    public String getSearchAppText() {
        return getText(SEARCH_XPATH);
    }


    public String getMapsAppText() {
        return getText(MAPS_XPATH);
    }

    public String getYoutubeAppText() {
        return getText(YOUTUBE_XPATH);
    }

    public String getPlayAppText() {
        return getText(PLAY_XPATH);
    }


    public String getGMailAppText() {
        return getText(GMAIL_XPATH);
    }

    public String getContactsAppText() {
        return getText(CONTACTS_XPATH);
    }

    public String getDriveAppText() {
        return getText(DRIVE_XPATH);
    }

    public String getCalendarAppText() {
        return getText(CALENDAR_XPATH);
    }

    public String getTranslateAppText() {
        return getText(TRANSLATE_XPATH);
    }

    public String getPhotosAppText() {
        return getText(PHOTOS_XPATH);
    }

    public String getDocsAppText() {
        return getText(DOCS_XPATH);
    }

    public String getBooksAppText() {
        return getText(BOOKS_XPATH);
    }

    public String getBLoggerAppText() {
        return getText(BLOGGER_XPATH);
    }

    private String getText(String xpath) {
        return actionEditor.getElementTextByXpath(xpath);

    }
}
