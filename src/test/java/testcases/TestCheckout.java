//package testcases;
//
//import base.Base;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import pageObjects.CartPage;
//import pageObjects.ProductsAdd;
//
//public class TestCheckout extends Base {
//
//    @Test
//    public void Checkout() throws InterruptedException {
//        Thread.sleep(5000); // Wait for the page to load
//        CartPage pg = new CartPage(driver);
//
//        // Interact with the Name field
//        pg.getNameField().sendKeys("Hasan al mamun");
//
//        pg.getLetsShopButton().click();
//
//        pg.ClickAddToCart1().click();
//
//        pg.ClickAddToCart2().click();
//
//        pg.ClickCartButton().click();
//
//        pg.ClickCheckBoxX().click();
//
//        pg.ClickCheckoutButton().click();
//
//        pg.ClickSearchBar().click();
//        Thread.sleep(3000);
//
//
//    }
//
//}
//


package testcases;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import com.aventstack.extentreports.Status;
import java.time.Duration;

public class TestCheckout extends Base {

    @Test
    public void Checkout() {
        test.log(Status.INFO, "Test case: Checkout started");

        CartPage pg = new CartPage(driver);

        // Interact with the Name field
        WebElement nameField = pg.getNameField();
        waitForElementToBeVisible(nameField, 10);
        nameField.sendKeys("Hasan al mamun");
        test.log(Status.INFO, "Entered name: Hasan al mamun");

        // Click "Let's Shop" button
        WebElement letsShopButton = pg.getLetsShopButton();
        waitForElementToBeVisible(letsShopButton, 10);
        letsShopButton.click();
        test.log(Status.INFO, "Clicked on Let's Shop button");

        // Add first product to the cart
        WebElement addToCart1 = pg.ClickAddToCart1();
        waitForElementToBeVisible(addToCart1, 10);
        addToCart1.click();
        test.log(Status.INFO, "Added product 1 to the cart");

        // Add second product to the cart
        WebElement addToCart2 = pg.ClickAddToCart2();
        waitForElementToBeVisible(addToCart2, 10);
        addToCart2.click();
        test.log(Status.INFO, "Added product 2 to the cart");

        // Navigate to cart
        WebElement cartButton = pg.ClickCartButton();
        waitForElementToBeVisible(cartButton, 10);
        cartButton.click();
        test.log(Status.INFO, "Navigated to cart");

        // Select checkbox
        WebElement checkBox = pg.ClickCheckBoxX();
        waitForElementToBeVisible(checkBox, 10);
        checkBox.click();
        test.log(Status.INFO, "Selected the checkbox");

        // Click checkout button
        WebElement checkoutButton = pg.ClickCheckoutButton();
        waitForElementToBeVisible(checkoutButton, 10);
        checkoutButton.click();
        test.log(Status.INFO, "Clicked on Checkout button");

        // Click search bar
        WebElement searchBar = pg.ClickSearchBar();
        waitForElementToBeVisible(searchBar, 10);
        searchBar.click();
        test.log(Status.INFO, "Clicked on Search bar");

        test.log(Status.PASS, "Checkout test completed successfully");
    }

    /**
     * Waits for an element to be visible before interacting with it.
     */
    public void waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
