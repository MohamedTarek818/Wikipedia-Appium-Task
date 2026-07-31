package screens;

import base_screen.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

    private final By searchButton = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"org.wikipedia:id/navigation_bar_item_icon_view\").instance(2)");
    private final By closeButton = AppiumBy.accessibilityId("Close");

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }
    public WebElement getCloseButton() {
        return findElement(closeButton);
    }
    public WebElement getSearchButton() {
        return findElement(searchButton);
    }
    public void clickOnCloseButton() {
        waitForClickable(closeButton);
        getCloseButton().click();
    }
    public void clickOnSearchButton() {
        getSearchButton().click();
    }
}