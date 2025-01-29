//package testcases;
//
//import base.Base;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import pageObjects.ProductsDisplay;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//public class TestProductsDisplay extends Base {
//
//    @Test
//    public void Checkout() throws InterruptedException, IOException {
//        Thread.sleep(5000); // Wait for the page to load
//        ProductsDisplay productsDisplay = new ProductsDisplay(driver);
//
//        // Interact with the Name field
//        productsDisplay.getNameField().sendKeys("Hasan al mamun");
//
//        productsDisplay.getLetsShopButton().click(); // click the letshop button
//
//        productsDisplay.ClickAddToCart1().click(); // add product 1 to the cart
//
//        productsDisplay.ClickAddToCart2().click(); // add product 2 to the cart
//
//        productsDisplay.ClickCheckoutButton().click();
//        Thread.sleep(3000);
//
//    }
//
//    @Test
//    public void CheckAddedItemDisplay() throws InterruptedException, IOException {
//
//
//        Checkout(); //Repeat the automated test steps under the Checkout method
//        // Initialize the ProductsDisplay object
//        ProductsDisplay productsDisplay = new ProductsDisplay(driver);
//
//        // Take a screenshot after adding products to the cart
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        String screenshotPath = "./screenshots/cart_validation.png";
//
//        // Check if the file exists and delete it
//        File screenshotFile = new File(screenshotPath);
//        if (screenshotFile.exists()) {
//            screenshotFile.delete(); // Delete the existing screenshot
//        }
//
//        // Create the directories if they don't exist
//        Files.createDirectories(Paths.get("./screenshots"));
//
//        // Copy the new screenshot to the desired location
//        Files.copy(screenshot.toPath(), Paths.get(screenshotPath), StandardCopyOption.REPLACE_EXISTING);
//        System.out.println("Screenshot taken and saved at: " + screenshotPath);
//
//        // Validate if products are displayed in the cart
//        WebElement cartItems1 = productsDisplay.getCartItems1();
//        WebElement cartItems2 = productsDisplay.getCartItems2();
//
//        // Validate both cart items
//        boolean isCartItem1Displayed = cartItems1.isDisplayed();
//        boolean isCartItem2Displayed = cartItems2.isDisplayed();
//
//        if (isCartItem1Displayed && isCartItem2Displayed) {
//            System.out.println("Both products are displayed in the cart.");
//        } else {
//            System.out.println("Failed to display both products.");
//        }
//
//        // Assert validation results
//        Assert.assertTrue(isCartItem1Displayed, "Validation failed: Cart item 1 is not displayed.");
//        Assert.assertTrue(isCartItem2Displayed, "Validation failed: Cart item 2 is not displayed.");
//    }
//}


package testcases;

import base.Base;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ProductsDisplay;
import com.aventstack.extentreports.Status;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class TestProductsDisplay extends Base {

    @Test
    public void Checkout() {
        test.log(Status.INFO, "Test case: Checkout started");

        ProductsDisplay productsDisplay = new ProductsDisplay(driver);

        // Enter name
        WebElement nameField = productsDisplay.getNameField();
        waitForElementToBeVisible(nameField, 10);
        nameField.sendKeys("Hasan al mamun");
        test.log(Status.INFO, "Entered name: Hasan al mamun");

        // Click "Let's Shop" button
        WebElement letsShopButton = productsDisplay.getLetsShopButton();
        waitForElementToBeVisible(letsShopButton, 10);
        letsShopButton.click();
        test.log(Status.INFO, "Clicked on Let's Shop button");

        // Add product 1 to cart
        WebElement addToCart1 = productsDisplay.ClickAddToCart1();
        waitForElementToBeVisible(addToCart1, 10);
        addToCart1.click();
        test.log(Status.INFO, "Added product 1 to the cart");

        // Add product 2 to cart
        WebElement addToCart2 = productsDisplay.ClickAddToCart2();
        waitForElementToBeVisible(addToCart2, 10);
        addToCart2.click();
        test.log(Status.INFO, "Added product 2 to the cart");

        // Click Checkout button
        WebElement checkoutButton = productsDisplay.ClickCheckoutButton();
        waitForElementToBeVisible(checkoutButton, 10);
        checkoutButton.click();
        test.log(Status.INFO, "Clicked on Checkout button");

        test.log(Status.PASS, "Checkout test passed");
    }

    @Test(dependsOnMethods = "Checkout")
    public void CheckAddedItemDisplay() throws IOException {
        test.log(Status.INFO, "Test case: CheckAddedItemDisplay started");

        ProductsDisplay productsDisplay = new ProductsDisplay(driver);

        // Take a screenshot after adding products to the cart
        takeScreenshot("cart_validation");
        test.log(Status.INFO, "Screenshot taken and saved");

        // Validate if products are displayed in the cart
        WebElement cartItems1 = productsDisplay.getCartItems1();
        WebElement cartItems2 = productsDisplay.getCartItems2();

        waitForElementToBeVisible(cartItems1, 10);
        waitForElementToBeVisible(cartItems2, 10);

        boolean isCartItem1Displayed = cartItems1.isDisplayed();
        boolean isCartItem2Displayed = cartItems2.isDisplayed();

        if (isCartItem1Displayed && isCartItem2Displayed) {
            test.log(Status.PASS, "Both products are displayed in the cart.");
        } else {
            test.log(Status.FAIL, "Failed to display both products in the cart.");
        }

        // Assert validation results
        Assert.assertTrue(isCartItem1Displayed, "Validation failed: Cart item 1 is not displayed.");
        Assert.assertTrue(isCartItem2Displayed, "Validation failed: Cart item 2 is not displayed.");

        test.log(Status.INFO, "Test case: CheckAddedItemDisplay ended");
    }

    /**
     * Waits for an element to be visible before interacting with it.
     */
    private void waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Takes a screenshot and saves it in the 'screenshots' folder.
     */
    public void takeScreenshot(String fileName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "./screenshots/" + fileName + ".png";

        // Ensure directory exists
        Files.createDirectories(Paths.get("./screenshots"));

        // Save screenshot
        Files.copy(screenshot.toPath(), Paths.get(screenshotPath), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Screenshot saved at: " + screenshotPath);
    }
}
