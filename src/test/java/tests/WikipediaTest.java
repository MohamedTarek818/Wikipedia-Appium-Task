package tests;

import base_test.BaseTest;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.ArticleScreen;
import screens.HomeScreen;
import screens.SearchScreen;
import screens.StartingScreen;

public class WikipediaTest extends BaseTest {

    private HomeScreen home;
    private SearchScreen search;
    private ArticleScreen articleScreen;
    private StartingScreen startingScreen;

    @Test
    public void testSaveArticleToReadingList() {
        String article = "Artificial Intelligence";
        String listName = "AI List";

        home = new HomeScreen(driver);
        search = new SearchScreen(driver);
        articleScreen = new ArticleScreen(driver);
        startingScreen = new StartingScreen(driver);

        skipOnboarding();
        openSearchScreen();
        searchForArticle(article);
        openFirstSearchResult();
        saveArticleToNewList(listName);
        confirmAndViewList();
        verifyArticleSavedInList(article);
    }

    @Step("Skip the onboarding screens")
    private void skipOnboarding() {
        startingScreen.skipOnboarding();
        startingScreen.clickOnSkipButton();
    }

    @Step("Open the search screen from home")
    private void openSearchScreen() {
        home.clickOnSearchButton();
        home.clickOnCloseButton();
    }

    @Step("Search for article: {article}")
    private void searchForArticle(String article) {
        search.clickOnSearchInputField();
        search.searchForArticle(article);
    }

    @Step("Open the first search result")
    private void openFirstSearchResult() {
        search.clickOnFirstResult();
        articleScreen.clickOnCloseButton();
    }

    @Step("Save article to a new reading list named: {listName}")
    private void saveArticleToNewList(String listName) {
        articleScreen.clickOnSaveButton();
        articleScreen.clickOnAddToListButton();
        articleScreen.createNewList(listName);
        articleScreen.clickOnOkButton();
    }

    @Step("Confirm save and view the reading list")
    private void confirmAndViewList() {
        articleScreen.clickOnViewListButton();
        articleScreen.clickOnGotItButton();
    }

    @Step("Verify article '{article}' is displayed in the list")
    private void verifyArticleSavedInList(String article) {
        Assert.assertTrue(articleScreen.isArticleTitleDisplayed(article));
    }
}