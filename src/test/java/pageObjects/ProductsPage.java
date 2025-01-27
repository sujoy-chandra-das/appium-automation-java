package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

import base.Locators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    public AppiumDriver driver;
    public WebDriverWait wait;

    Locators locators = new Locators();

    public ProductsPage(AppiumDriver driver) {
        this.driver = (AndroidDriver) driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
    }

    public WebElement ClickCountrydropdownIcon() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.dropdown_CountryId)));
    }


    public WebElement SelectCountry(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.element_CountryXpath)));
    }

    public WebElement getNameField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.text_box_NameId)));
    }

    public WebElement getGender() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.checkbox_Gender_Xpath)));
    }

    public WebElement getLetsShopButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.Button_LetsShop_Id)));


    }

    public WebElement ProductsTitleAppear() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.title_Products_Xpath)));


    }

}
