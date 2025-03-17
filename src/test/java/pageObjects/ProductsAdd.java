package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

import base.Locators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductsAdd  {

    public AppiumDriver driver;
    public WebDriverWait wait;

    Locators locators = new Locators();

    public ProductsAdd(AppiumDriver driver) {

        this.driver = (AndroidDriver) driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
    }

    public WebElement ClickAddToCart1() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.AddtoCart1_Xpath)));

    }

    public WebElement ClickAddToCart2() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.AddtoCart2_Xpath)));
    }

    public WebElement ClickCartButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.Button_Cart_ID)));
    }

    public WebElement CartTitleAppear() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.Title_CartID)));

    }

    public WebElement getNameField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.text_box_NameId)));

    }

    public WebElement getLetsShopButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.Button_LetsShop_Id)));

    }
}
