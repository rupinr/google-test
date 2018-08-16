package com.google.test;

import com.google.test.pages.SearchResultPage;
import com.google.test.support.annotations.TestCase;
import com.google.test.test.BaseTest;
import org.testng.annotations.Test;

import static com.google.test.support.Priority.HIGH;
import static org.testng.Assert.assertEquals;

public class HomePageTest extends BaseTest {

    @Test
    @TestCase(id = "TC001", priority = HIGH, description = "Verify that user is able search after" +
            "entering text in search field and clicking on Search button")
    public void verifyGoogleSearchResultPage() {
        String searchText = "Market Logic Software";
        SearchResultPage searchResultPage = this.getTestDriver()
                .openGoogleHomePage()
                .editSearchText(searchText)
                .openGoogleSearchResultPage();

        assertEquals(searchResultPage.getSearchText(), searchText);
        assertEquals(searchResultPage.getPageTitle(), searchText + " - " + BaseTest.textHolder.getText("search_title"));

    }

}
