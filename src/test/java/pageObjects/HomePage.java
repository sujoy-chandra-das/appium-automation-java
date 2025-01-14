package pageObjects;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;
import base.Locators;
import org.testng.Assert;

public class HomePage {

    public AppiumDriver driver;
    Locators locators = new Locators();

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement getNameField() {
        return driver.findElement(By.id(Locators.text_box_NameId));
    }

    public WebElement getGenderButton() {
        return driver.findElement(By.xpath(Locators.checkbox_Gender_Xpath)); // Fixed the typo from "Gendor" to "Gender"
    }

}
