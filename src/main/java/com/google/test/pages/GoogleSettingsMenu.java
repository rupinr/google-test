package com.google.test.pages;

import com.google.test.component.BaseActionEditor;
import com.google.test.locators.Replacements;
import org.openqa.selenium.WebDriver;

public class GoogleSettingsMenu extends BasePage {

    private BaseActionEditor actionEditor;

    private static final String MENU_ITEM_COMMON_XPATH = "(//*[@id='fsett']//a)[{I}]";

    public GoogleSettingsMenu(WebDriver driver) {
        super(driver);
        actionEditor = new BaseActionEditor(driver);
    }


    private String getText(int index) {
        return actionEditor.getElementTextByXpath(MENU_ITEM_COMMON_XPATH.replace(Replacements.I, String.valueOf(index)));
    }

    public String getSearchSettingsText() {
        return getText(1);
    }

    public String getAdvancedSearchText() {
        return getText(2);
    }

    public String getHistoryText() {
        return getText(3);
    }

    public String getSearchHelpText() {
        return getText(4);
    }

    public String getSendFeedbackText() {
        return getText(5);
    }


}
