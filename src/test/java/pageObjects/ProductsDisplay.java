package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

import base.Locators;
import org.xml.sax.Locator;

import java.util.List;

public class ProductsDisplay extends CartPage {

    Locators locators = new Locators();

    public ProductsDisplay(AppiumDriver driver) {
        super(driver); // Call the parent class constructor
    }

    public WebElement ClickCheckBoxX() {
        return driver.findElement(By.className(Locators.Checkbox_Cart_ClassName));
    }

    public WebElement ClickCheckoutButton() {
        return driver.findElement(By.id(Locators. Button_Cart_ID));
    }

    /// /    public WebElement Cart1Display() {
    /// /        return driver.findElement(By.id(Locators.Cart1Display_xpath));
    /// /    }
    /// /
    /// /    public WebElement Cart2Display() {
    /// /        return driver.findElement(By.id(Locators.Cart2Display_xpath));
    /// /    }
//
//    public List<WebElement> getCartItems() {
//        return (List<WebElement>) driver.findElement(By.xpath(Locators.Cart1Display_xpath));
//    }
//
//    public List<WebElement> getCartItems2() {
//        return (List<WebElement>) driver.findElement(By.xpath(Locators.Cart2Display_xpath));
//    }
//
// //return driver.findElement(By.xpath(Locators.Cart1Display_xpath)); // Replace with the correct locator
//

// Method to get CartItems1
    public WebElement getCartItems1() {
        return driver.findElement(By.xpath(Locators.Cart1Display_xpath)); // Replace with actual locator for CartItems1
    }

    // Method to get CartItems2
    public WebElement getCartItems2() {
        return driver.findElement(By.xpath(Locators.Cart2Display_xpath));


    }
}