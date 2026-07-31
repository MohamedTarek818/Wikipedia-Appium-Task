package base_screen;

import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseScreen {
    protected final AndroidDriver driver;

    protected BaseScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    protected static WebElement waitForVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    protected static WebElement waitForClickable(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebElement findElement(By locator) {
        try {
            WebElement element = waitForVisible(locator);
            return element;
        } catch (TimeoutException e) {
            e.printStackTrace();
            return null;
        }
    }
}