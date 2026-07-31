package screens;

import base_screen.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchScreen extends BaseScreen {

    private final By searchInputField = AppiumBy.accessibilityId("Search Wikipedia");
    private final By searchBar = AppiumBy.id("org.wikipedia:id/search_src_text");
    private final By firstResult = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.view.View\").instance(3)");

    public SearchScreen(AndroidDriver driver) {
        super(driver);
    }

    public WebElement getSearchInputField() {
        return findElement(searchInputField);
    }

    public WebElement getFirstResult() {
        return findElement(firstResult);
    }
    public WebElement getSearchBar() {
        return findElement(searchBar);
    }

    public void clickOnFirstResult() {
        getFirstResult().click();
    }
    public void clickOnSearchInputField() {
        waitForClickable(searchInputField);
        getSearchInputField().click();
    }

    public void searchForArticle(String article) {
        waitForVisible(searchBar);
        getSearchBar().sendKeys(article);
    }
}