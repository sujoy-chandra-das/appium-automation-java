package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;
import base.Locators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    public AndroidDriver driver;
    public WebDriverWait wait;

    // Constructor to initialize driver and wait
    public HomePage(AppiumDriver driver) {
        this.driver = (AndroidDriver) driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20)); // Proper initialization
    }


    public WebElement getNameField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.text_box_NameId)));
    }

}
