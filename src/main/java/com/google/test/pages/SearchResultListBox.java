package com.google.test.pages;

import com.google.test.component.BaseActionEditor;
import com.google.test.locators.Replacements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultListBox extends BasePage {

    private static final String SEARCH_RESULT_ENTRY_ALL_XPATH = "//*[@class='sbqs_c']";
    private static final String SEARCH_RESULT_ENTRY_BY_INDEX_XPATH = "(//*[@class='sbqs_c'])[{I}]";

    private BaseActionEditor editor;


    public SearchResultListBox(WebDriver driver) {
        super(driver);
        editor = new BaseActionEditor(driver);
    }

    public List<String> getAllSearchResult() {
        return this.driver.findElements(By.xpath(SEARCH_RESULT_ENTRY_ALL_XPATH))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public SearchResultPage clickOnSearchSuggestionByIndex(int index) {
        this.editor.clickOnElementByXpath(SEARCH_RESULT_ENTRY_BY_INDEX_XPATH.replace(Replacements.I, String.valueOf(index)));
        return new SearchResultPage(driver);
    }
}
