package screens;

import base_screen.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticleScreen extends BaseScreen {

    private final By closeButton = AppiumBy.accessibilityId("Close");
    private final By saveButton = AppiumBy.accessibilityId("Save");
    private final By addToListButton = AppiumBy.id("org.wikipedia:id/snackbar_action");
    private final By createNewButton = AppiumBy.id("org.wikipedia:id/create_button");
    private final By listNameField = AppiumBy.id("org.wikipedia:id/text_input");
    private final By okButton = AppiumBy.id("android:id/button1");
    private final By viewListButton = AppiumBy.id("org.wikipedia:id/snackbar_action");
    private final By gotItButton = AppiumBy.id("org.wikipedia:id/buttonView");

    public ArticleScreen(AndroidDriver driver) {
        super(driver);
    }

    public WebElement getSaveButton() {
        return findElement(saveButton);
    }
    public WebElement getCloseButton() {
        return findElement(closeButton);
    }
    public WebElement getAddToListButton() {
        return findElement(addToListButton);
    }
    public WebElement getCreateNewButton() {
        return findElement(createNewButton);
    }
    public WebElement getListNameField() {
        return findElement(listNameField);
    }
    public WebElement getOkButton() {
        return findElement(okButton);
    }
    public WebElement getViewListButton() {
        return findElement(viewListButton);
    }
    public WebElement getGotItButton() {
        return findElement(gotItButton);
    }
    public void clickOnGotItButton() {
        waitForClickable(gotItButton);
        getGotItButton().click();
    }
    public void clickOnSaveButton() {
        getSaveButton().click();
    }
    public void clickOnAddToListButton() {
        getAddToListButton().click();
    }
    public void clickOnCreateNewButton() {
        getCreateNewButton().click();
    }
    public void clickOnOkButton() {
        getOkButton().click();
    }
    public void clickOnCloseButton() {
        waitForClickable(closeButton);
        getCloseButton().click();
    }
    public void clickOnViewListButton() {
        getViewListButton().click();
    }
    public void createNewList(String listName) {
        getListNameField().sendKeys(listName);
    }
    public boolean isArticleTitleDisplayed(String articleName) {
        By articleTitle = AppiumBy.id("org.wikipedia:id/page_list_item_title");
        return findElement(articleTitle) != null;
    }
}