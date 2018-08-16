package com.google.test.pages;

import com.google.test.component.BaseActionEditor;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {


    private static final String DID_YOU_MEAN_XPATH = "//*[@class='ssp card-section']";
    private static final String SEARCH_INPUT_ID = "lst-ib";
    private static final String SEARCH_BUTTON_ID = "mKlEF";

    private BaseActionEditor editor;


    public SearchResultPage(WebDriver driver) {
        super(driver);
        editor = new BaseActionEditor(driver);
    }

    public String getDidYouMeanText() {
        return this.editor.getElementTextByXpath(DID_YOU_MEAN_XPATH);
    }

    public SearchResultPage editSearchText(String searchText) {
        this.editor.editTextFieldById(SEARCH_INPUT_ID, searchText);
        return this;
    }

    public SearchResultPage clickOnSearchButton() {
        this.editor.clickOnElementById(SEARCH_BUTTON_ID);
        return this;
    }

    public String getSearchText() {
        return this.editor.getInputFieldTextById(SEARCH_INPUT_ID);
    }
}
