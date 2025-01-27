package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

import base.Locators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends ProductsAdd {

    //Locators locators = new Locators();

    public CartPage(AppiumDriver driver) {

        super(driver);  // Call the parent class constructor
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));

    }

    //  return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.dropdown_CountryId)));
    public WebElement ClickCheckBoxX() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.Checkbox_Cart_Xpath)));
    }

    public WebElement ClickCheckoutButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.Button_CheckoutId)));

    }

    public WebElement getCheckoutPageTitle() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.Title_AfterCheckout_Id)));
    }

    public WebElement ClickSearchBar() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.SearchBar_Id)));
    }

}