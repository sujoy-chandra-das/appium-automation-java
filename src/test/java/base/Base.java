package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Base {

    public AndroidDriver driver;
    public WebDriverWait wait;

    @BeforeTest // Open the session
    public void setup() throws MalformedURLException {
        String appiumServerUrl = "http://127.0.0.1:4723";

        // Get the path of the APK file in the project directory
        String apkPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "General-Store.apk";

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "uiautomator2");
        dc.setCapability("appium:app", apkPath);
        // Uncomment the following line if you want to auto-grant permissions
        // dc.setCapability("autoGrantPermissions", true);

        driver = new AndroidDriver(new URL(appiumServerUrl), dc);

        // Initialize WebDriverWait with a default timeout of 20 seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterTest // Close the session
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
