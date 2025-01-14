package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

import base.Locators;

public class HomePage {

    private AppiumDriver driver;
    Locators locators = new Locators();

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Dynamically fetch locators from the Locators class
    public WebElement getNameField() {
        return driver.findElement(By.id(Locators.text_box_NameId));
    }

    public WebElement getFemaleButton() {
        return driver.findElement(By.xpath(Locators.checkbox_Gender_Xpath));
    }
}
