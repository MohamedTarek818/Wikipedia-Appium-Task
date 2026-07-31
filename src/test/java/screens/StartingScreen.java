package screens;

import base_screen.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class StartingScreen extends BaseScreen {

    public StartingScreen(AndroidDriver driver) {
        super(driver);
    }
    private final By skipArrow = AppiumBy.accessibilityId("Forward");
    private final By skipButton = AppiumBy.xpath("//android.widget.TextView[@text='Skip']");

    public WebElement getSkipArrow() {
        return driver.findElement(skipArrow);
    }
    public WebElement getSkipButton() {
        return driver.findElement(skipButton);
    }
    public void clickOnSkipArrow() {
        waitForClickable(skipArrow);
        getSkipArrow().click();
    }
    public void skipOnboarding() {
        while (isSkipArrowDisplayed()) {
            clickOnSkipArrow();
        }
    }
    public void clickOnSkipButton() {
        waitForClickable(skipButton);
        getSkipButton().click();
    }

    private boolean isSkipArrowDisplayed() {
        try {
            WebElement el = findElement(skipArrow);
            return el != null;
        } catch (Exception e) {
            return false;
        }
    }

}
