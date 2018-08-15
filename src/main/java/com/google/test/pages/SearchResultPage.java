package com.google.test.pages;

import com.google.test.component.BaseActionEditor;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {


    private static final String DID_YOU_MEAN_XPATH = "//*[@class='ssp card-section']";
    private BaseActionEditor editor;


    public SearchResultPage(WebDriver driver) {
        super(driver);
        editor = new BaseActionEditor(driver);
    }

    public String getDidYouMeanText() {
        return this.editor.getElementTextByXpath(DID_YOU_MEAN_XPATH);
    }
}
