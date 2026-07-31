package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("deviceName");
            options.setPlatformVersion("platformVersion");
            options.setAppPackage("org.wikipedia");
            options.setAppActivity("org.wikipedia.main.MainActivity");
            options.setAutomationName("UiAutomator2");
            options.setCapability("newCommandTimeout", 1200);
            options.setCapability("autoDismissAlerts", true);


            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}