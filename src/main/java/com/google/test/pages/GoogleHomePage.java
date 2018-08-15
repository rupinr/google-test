package com.google.test.pages;

import com.google.test.component.BaseActionEditor;
import org.openqa.selenium.WebDriver;

import static com.google.test.locators.Replacements.I;

public class GoogleHomePage extends BasePage {

    private static final String GOOGLE_LOGO_ID = "hplogo";
    private static final String SEARCH_INPUT_ID = "lst-ib";
    private static final String SEARCH_BUTTON_NAME = "btnK";
    private static final String I_AM_FEELING_LUCKY_NAME = "btnI";
    private static final String VOICE_INPUT_BUTTON_ID = "gsri_ok0";
    private static final String GOOGLE_APPS_ID = "gbwa";
    private static final String GOOGLE_LOGIN_ID = "gb_70";
    private static final String COUNTRY_NAME_XPATH = "//*[@class='Q8LRLc']";
    private static final String FOOTER_LINKS_COMMON_XPATH = "(//*[@class='Fx4vi'])[{I}]";


    private BaseActionEditor actionEditor;


    public GoogleHomePage(WebDriver driver) {
        super(driver);
        this.actionEditor = new BaseActionEditor(driver);
    }

    public GoogleHomePage editSearchText(String searchText) {
        this.enterSearchText(searchText);
        return this;
    }

    public VoiceSearchPage openVoiceSearchPage() {
        this.actionEditor.clickOnElementById(VOICE_INPUT_BUTTON_ID);
        return new VoiceSearchPage(driver);
    }

    public SearchResultPage openGoogleSearchResultPage() {
        this.actionEditor.moveToElementAndClickByName(SEARCH_BUTTON_NAME);
        return new SearchResultPage(driver);
    }

    public GoogleDoodlesPage openGoogleDoodlesPage() {
        this.actionEditor.clickOnElementByName(I_AM_FEELING_LUCKY_NAME);
        return new GoogleDoodlesPage(driver);
    }

    public GoogleAppsMenu openGoogleAppsHint() {
        this.actionEditor.clickOnElementById(GOOGLE_APPS_ID);
        return new GoogleAppsMenu(driver);
    }

    public GoogleLoginPage openGoogleLoginPage() {
        this.actionEditor.clickOnElementById(GOOGLE_LOGIN_ID);
        return new GoogleLoginPage(driver);
    }

    public SearchResultListBox editSearchTextToSelectFromSearchResult(String searchText) {
        this.enterSearchText(searchText);
        return new SearchResultListBox(driver);
    }

    public String getCountryNameText() {
        return this.actionEditor.getElementTextByXpath(COUNTRY_NAME_XPATH);
    }

    public String getAdvertisingText() {
        return this.actionEditor.getElementTextByXpath(FOOTER_LINKS_COMMON_XPATH.replace(I, "4"));
    }

    public String getBusinessText() {
        return this.actionEditor.getElementTextByXpath(FOOTER_LINKS_COMMON_XPATH.replace(I, "5"));
    }

    public String getAboutText() {
        return this.actionEditor.getElementTextByXpath(FOOTER_LINKS_COMMON_XPATH.replace(I, "6"));
    }

    public String getPrivacyText() {
        return this.actionEditor.getElementTextByXpath(FOOTER_LINKS_COMMON_XPATH.replace(I, "1"));
    }

    public String getTermsText() {
        return this.actionEditor.getElementTextByXpath(FOOTER_LINKS_COMMON_XPATH.replace(I, "2"));
    }

    public String getSettingsText() {
        return this.actionEditor.getElementTextByXpath(FOOTER_LINKS_COMMON_XPATH.replace(I, "3"));
    }


    private void enterSearchText(String searchText) {
        this.actionEditor.editTextFieldById(SEARCH_INPUT_ID, searchText);
    }
}
