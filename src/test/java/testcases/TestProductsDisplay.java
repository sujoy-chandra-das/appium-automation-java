package testcases;

import base.Base;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ProductsDisplay;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestProductsDisplay extends Base {

    @Test
    public void Checkout() throws InterruptedException, IOException {
        Thread.sleep(5000); // Wait for the page to load
        ProductsDisplay productsDisplay = new ProductsDisplay(driver);

        // Interact with the Name field
        productsDisplay.getNameField().sendKeys("Hasan al mamun");
        Thread.sleep(5000); // Wait for any action to take effect

        productsDisplay.getLetsShopButton().click(); // click the letshop button
        Thread.sleep(3000);

        productsDisplay.ClickAddToCart1().click(); // add product 1 to the cart
        Thread.sleep(3000);

        productsDisplay.ClickAddToCart2().click(); // add product 2 to the cart
        Thread.sleep(3000);

        productsDisplay.ClickCheckoutButton().click();
        Thread.sleep(3000);

        // Take a screenshot after adding products to the cart
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "./screenshots/cart_validation.png";

        // Check if the file exists and delete it
        File screenshotFile = new File(screenshotPath);
        if (screenshotFile.exists()) {
            screenshotFile.delete(); // Delete the existing screenshot
        }

        // Create the directories if they don't exist
        Files.createDirectories(Paths.get("./screenshots"));

        // Copy the new screenshot to the desired location
        Files.copy(screenshot.toPath(), Paths.get(screenshotPath), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Screenshot taken and saved at: " + screenshotPath);

        // Validate if products are displayed in the cart
        WebElement cartItems1 = productsDisplay.getCartItems1();
        WebElement cartItems2 = productsDisplay.getCartItems2();

        // Validate both cart items
        boolean isCartItem1Displayed = cartItems1.isDisplayed();
        boolean isCartItem2Displayed = cartItems2.isDisplayed();

        if (isCartItem1Displayed && isCartItem2Displayed) {
            System.out.println("Both products are displayed in the cart.");
        } else {
            System.out.println("Failed to display both products.");
        }

        // Assert validation results
        Assert.assertTrue(isCartItem1Displayed, "Validation failed: Cart item 1 is not displayed.");
        Assert.assertTrue(isCartItem2Displayed, "Validation failed: Cart item 2 is not displayed.");
    }
}
