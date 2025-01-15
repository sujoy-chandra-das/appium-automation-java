package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

import base.Locators;

public class ProductsPage {
    public AppiumDriver driver;
    Locators locators = new Locators();

    public ProductsPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement ClickCountrydropdownIcon(){
        return driver.findElement(By.id(Locators.dropdown_CountryId));
    }

    public WebElement SelectCountry(){
        return driver.findElement(By.xpath(Locators.element_CountryXpath));
    }

    public WebElement getNameField() {
        return driver.findElement(By.id(Locators.text_box_NameId));
    }

    public WebElement getGender() {
        return driver.findElement(By.id(Locators.checkbox_Gender_Xpath));
    }

    public WebElement getLetsShopButton() {
        return driver.findElement(By.id(Locators.Button_LetsShop_Id));
    }

}
