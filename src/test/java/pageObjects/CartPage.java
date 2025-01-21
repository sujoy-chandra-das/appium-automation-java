package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

import base.Locators;

public class CartPage extends ProductsAdd {

    Locators locators = new Locators();

    public CartPage(AppiumDriver driver) {
        super(driver); // Call the parent class constructor
    }

    public WebElement ClickCheckBoxX() {
        return driver.findElement(By.className(Locators.Checkbox_Cart_ClassName));
    }

    public WebElement ClickCheckoutButton() {
        return driver.findElement(By.id(Locators.Button_CheckoutId));
    }

    public WebElement getCheckoutPageTitle() {
        return driver.findElement(By.id(Locators.Title_AfterCheckout_Id));
    }

    public WebElement ClickSearchBar() {
        return driver.findElement(By.id(Locators.SearchBar_Id));
    }

}