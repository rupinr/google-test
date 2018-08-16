package com.google.test;

import com.google.test.pages.GoogleDoodlesPage;
import com.google.test.pages.GoogleHomePage;
import com.google.test.pages.SearchResultListBox;
import com.google.test.pages.SearchResultPage;
import com.google.test.support.annotations.TestCase;
import com.google.test.test.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.test.support.Priority.HIGH;
import static com.google.test.support.Priority.MEDIUM;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


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
        assertEquals(searchResultPage.getPageTitle(), searchText + " - " + textHolder.getText("search_title"));

    }

    @Test
    @TestCase(id = "TC002", priority = HIGH, description = "Verify that user is suggested with correct" +
            "spelling if there is an incorrect spelling in the search string")
    public void verifyIncorrectSpellingSerch() {
        String searchText = "google i gooood";
        SearchResultPage searchResultPage = this.getTestDriver()
                .openGoogleHomePage()
                .editSearchText(searchText)
                .openGoogleSearchResultPage();

        assertEquals(searchResultPage.getSearchText(), searchText);
        assertTrue(searchResultPage.getDidYouMeanText().contains(textHolder.getText("did_you_mean")));

    }

    @Test
    @TestCase(id = "TC003", priority = MEDIUM, description = "Verify that user is not navigated from homepage" +
            "on clicking Search button without entering any text")
    public void clickSearchButtonWithoutEnteringAnyText() {
        GoogleHomePage searchHome = this.getTestDriver()
                .openGoogleHomePage()
                .clickSearchButtonWithoutEnteringText();

        assertEquals(searchHome.getPageUrl(), testProperties.getHomePageURL());

    }

    @Test
    @TestCase(id = "TC004", priority = MEDIUM, description = "Verify that user is navigated to Google " +
            "Doodles page on clicking I am Feeling Lucky button without entering any search text")
    public void clickIAmFeelingLuckyButtonWithoutEnteringAnyText() {
        GoogleDoodlesPage googleDoodlesPage = this.getTestDriver()
                .openGoogleHomePage()
                .clickIAmFeelingLuckyButtonWithoutEnteringAnyText();

        assertEquals(googleDoodlesPage.getPageTitle(), textHolder.getText("google_doodles"));

    }

    @Test
    @TestCase(id = "TC005", priority = MEDIUM, description = "Verify that user is presented with" +
            "matching search suggestions")
    public void verifyThatUserIsPresentedWithMatchingSearchSuggestions() {
        String searchText = "google";
        List<String> searchSuggestions = this.getTestDriver()
                .openGoogleHomePage()
                .editSearchTextToSelectFromSearchResult(searchText)
                .getAllSearchResult();

        assertEquals(searchSuggestions.size(),10);
        searchSuggestions
                .forEach(result -> assertTrue(result.contains(searchText)));

    }

}
