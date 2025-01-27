package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

import base.Locators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsDisplay extends CartPage {

    //Locators locators = new Locators();
    public WebDriverWait wait;

    public ProductsDisplay(AppiumDriver driver) {
        super(driver);// Call the parent class constructor
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
    }
       // return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.dropdown_CountryId)));


    public WebElement ClickCheckoutButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.Button_Cart_ID)));
    }

    public WebElement getCartItems1() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.Cart1Display_xpath)));
    }

    // Method to get CartItems2
    public WebElement getCartItems2() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.Cart2Display_xpath)));


    }
}