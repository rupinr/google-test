package com.google.test;

import com.google.test.pages.*;
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
    @TestCase(id = "TC005", priority = HIGH, description = "Verify that user is presented with" +
            "matching search suggestions")
    public void verifyThatUserIsPresentedWithMatchingSearchSuggestions() {
        String searchText = "google";
        List<String> searchSuggestions = this.getTestDriver()
                .openGoogleHomePage()
                .editSearchTextToSelectFromSearchResult(searchText)
                .getAllSearchResult();

        assertEquals(searchSuggestions.size(), 10);
        searchSuggestions
                .forEach(result -> assertTrue(result.contains(searchText)));

    }

    @Test
    @TestCase(id = "TC006", priority = HIGH, description = "Verify the title of Google apps")
    public void verifyGoogleAppsTitle() {
        GoogleAppsMenu googleAppsMenu = this.getTestDriver()
                .openGoogleHomePage()
                .openGoogleAppsHint()
                .clickOnMoreButton();

        assertEquals(googleAppsMenu.getAccountAppText(), textHolder.getText("account"));
        assertEquals(googleAppsMenu.getSearchAppText(), textHolder.getText("search"));
        assertEquals(googleAppsMenu.getMapsAppText(), textHolder.getText("maps"));


        assertEquals(googleAppsMenu.getYoutubeAppText(), textHolder.getText("youtube"));
        assertEquals(googleAppsMenu.getPlayAppText(), textHolder.getText("play"));
        assertEquals(googleAppsMenu.getGMailAppText(), textHolder.getText("gmail"));


        assertEquals(googleAppsMenu.getContactsAppText(), textHolder.getText("contacts"));
        assertEquals(googleAppsMenu.getDriveAppText(), textHolder.getText("drive"));
        assertEquals(googleAppsMenu.getCalendarAppText(), textHolder.getText("calendar"));


        assertEquals(googleAppsMenu.getTranslateAppText(), textHolder.getText("translate"));
        assertEquals(googleAppsMenu.getPhotosAppText(), textHolder.getText("photos"));


        assertEquals(googleAppsMenu.getDocsAppText(), textHolder.getText("docs"));
        assertEquals(googleAppsMenu.getBooksAppText(), textHolder.getText("books"));
        assertEquals(googleAppsMenu.getBLoggerAppText(), textHolder.getText("blogger"));

        assertEquals(googleAppsMenu.getHangoutAppText(), textHolder.getText("hangouts"));
        assertEquals(googleAppsMenu.getKeepAppText(), textHolder.getText("keep"));
        assertEquals(googleAppsMenu.getEarthAppText(), textHolder.getText("earth"));

    }

    @Test
    @TestCase(id = "TC007", priority = HIGH, description = "Verify the footer links of google homepage")
    public void verifyGoogleHomePageFooterText() {
        GoogleHomePage googleHomePage = this.getTestDriver()
                .openGoogleHomePage();

        assertEquals(googleHomePage.getAdvertisingText(), textHolder.getText("advertising"));
        assertEquals(googleHomePage.getBusinessText(), textHolder.getText("business"));
        assertEquals(googleHomePage.getAboutText(), textHolder.getText("about"));

        assertEquals(googleHomePage.getPrivacyText(), textHolder.getText("privacy"));
        assertEquals(googleHomePage.getTermsText(), textHolder.getText("terms"));
        assertEquals(googleHomePage.getSettingsText(), textHolder.getText("settings"));
    }

    @Test
    @TestCase(id = "TC008", priority = HIGH, description = "Verify the entries in settings menu")
    public void verifyEntriesInSettingsMenu() {
        GoogleSettingsMenu googleSettingsMenu = this.getTestDriver()
                .openGoogleHomePage()
                .openGoogleSettings();

        assertEquals(googleSettingsMenu.getSearchSettingsText(), textHolder.getText("search_settings"));
        assertEquals(googleSettingsMenu.getAdvancedSearchText(), textHolder.getText("advanced_search"));
        assertEquals(googleSettingsMenu.getHistoryText(), textHolder.getText("history"));
        assertEquals(googleSettingsMenu.getSearchHelpText(), textHolder.getText("search_help"));
        assertEquals(googleSettingsMenu.getSendFeedbackText(), textHolder.getText("send_feedback"));

    }

    @Test
    @TestCase(id = "TC009", priority = HIGH, description = "Verify that user is navigated to Google" +
            "image search page")
    public void verifyNavigationToImageSearchPage() {
        GoogleLoginPage googleLoginPage = this.getTestDriver()
                .openGoogleHomePage()
                .openGoogleLoginPage();

        assertEquals(googleLoginPage.getPageTitle(),textHolder.getText("login_title"));



    }

    @Test
    @TestCase(id = "TC010", priority = HIGH, description = "Verify that user is navigated to Login Page")
    public void verifyNavigationToLoginPage() {
        GoogleImageSearchPage googleImageSearchPage = this.getTestDriver()
                .openGoogleHomePage()
                .openGoogleImageSearchPage();

        assertEquals(googleImageSearchPage.getPageTitle(),textHolder.getText("image_title"));


    }
}
