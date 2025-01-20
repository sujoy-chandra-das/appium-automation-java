package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

import base.Locators;

public class ProductsAdd extends ProductsPage {

    Locators locators = new Locators();

    public ProductsAdd(AppiumDriver driver) {
        super(driver); // Call the parent class constructor
    }

    public WebElement ClickAddToCart1() {
        return driver.findElement(By.xpath(Locators.AddtoCart1_Xpath));
    }

    public WebElement ClickAddToCart2() {
        return driver.findElement(By.xpath(Locators.AddtoCart2_Xpath));
    }

    public WebElement ClickCartButton() {
        return driver.findElement(By.id(Locators.Button_Cart_ID));
    }

    public WebElement CartTitleAppear() {
        return driver.findElement(By.id(Locators.Title_CartID));
    }


}
