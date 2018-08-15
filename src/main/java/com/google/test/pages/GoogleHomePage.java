package com.google.test.pages;

import com.google.test.component.BaseActionEditor;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends BasePage {

    private static final String GOOGLE_LOGO_ID = "hplogo";
    private static final String SEARCH_INPUT_ID = "lst-ib";
    private static final String SEARCH_BUTTON_NAME = "btnK";
    private static final String I_AM_FEELING_LUCKY_NAME = "btnI";
    private static final String VOICE_INPUTB_BUTTON_ID = "gsri_ok0";


    private BaseActionEditor actionEditor;


    public GoogleHomePage(WebDriver driver) {
        super(driver);
        this.actionEditor = new BaseActionEditor(driver);
    }

    public GoogleHomePage editSearchText(String searchText) {
        this.enterSearchText(searchText);
        return this;
    }

    public SearchResultListBox editSearchTextToSelectFromSearchResult(String searchText) {
        this.enterSearchText(searchText);
        return new SearchResultListBox(driver);
    }



    private void enterSearchText(String searchText) {
        this.actionEditor.editTextFieldById(SEARCH_INPUT_ID, searchText);
    }
}
