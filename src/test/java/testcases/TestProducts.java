//package testcases;
//
//import base.Base;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import pageObjects.ProductsAdd;
//
//
//public class TestProducts extends Base {
//
//    @Test
//    public void CartPageDisplay() throws InterruptedException {
//        Thread.sleep(5000); // Wait for the page to load
//        ProductsAdd pg = new ProductsAdd(driver);
//
//        // Interact with the Name field
//        pg.getNameField().sendKeys("Hasan al mamun");
//        pg.getLetsShopButton().click();
//        pg.ClickAddToCart1().click();
//        pg.ClickAddToCart2().click();
//        pg.ClickCartButton().click();
//        Thread.sleep(3000);
//
//    }
//
//    @Test
//    public void DisplayCartPageTitleGetandAssert() throws InterruptedException {
//
//        CartPageDisplay(); //Repeat the automated test steps under the CartPageDisplay method
//        ProductsAdd pg = new ProductsAdd(driver);
//
//        WebElement pageTitleElement = pg.CartTitleAppear();
//        // Fetch and print the title of the Products page
//        try {
//            // Assuming this locator gets the title element
//            String pageTitle = pageTitleElement.getText(); // Fetch the text of the title element
//            System.out.println("Current Page Title: " + pageTitle);
//        } catch (Exception e) {
//            System.out.println("Error: Unable to fetch page title. " + e.getMessage());
//        }
//
//
//        String actualTitle = pageTitleElement.getText();
//        String expectedTitle = "Cart";
//        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
//        System.out.println("Title assertion passed!");
//
//
//        Thread.sleep(3000);
//
//
//    }
//}
//

package testcases;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ProductsAdd;
import com.aventstack.extentreports.Status;

import java.time.Duration;

public class TestProducts extends Base {

    @Test
    public void CartPageDisplay() {
        test.log(Status.INFO, "Test case: CartPageDisplay started");

        ProductsAdd pg = new ProductsAdd(driver);

        // Enter name
        WebElement nameField = pg.getNameField();
        waitForElementToBeVisible(nameField, 10);
        nameField.sendKeys("Hasan al mamun");
        test.log(Status.INFO, "Entered name: Hasan al mamun");

        // Click "Let's Shop"
        WebElement letsShopButton = pg.getLetsShopButton();
        waitForElementToBeVisible(letsShopButton, 10);
        letsShopButton.click();
        test.log(Status.INFO, "Clicked on Let's Shop button");

        // Add products to the cart
        WebElement addToCart1 = pg.ClickAddToCart1();
        waitForElementToBeVisible(addToCart1, 10);
        addToCart1.click();
        test.log(Status.INFO, "Clicked Add to Cart for product 1");

        WebElement addToCart2 = pg.ClickAddToCart2();
        waitForElementToBeVisible(addToCart2, 10);
        addToCart2.click();
        test.log(Status.INFO, "Clicked Add to Cart for product 2");

        // Open the cart page
        WebElement cartButton = pg.ClickCartButton();
        waitForElementToBeVisible(cartButton, 10);
        cartButton.click();
        test.log(Status.INFO, "Clicked on Cart button");

        test.log(Status.PASS, "CartPageDisplay test passed");
    }

    @Test(dependsOnMethods = "CartPageDisplay")
    public void DisplayCartPageTitleGetandAssert() {
        test.log(Status.INFO, "Test case: DisplayCartPageTitleGetandAssert started");

        ProductsAdd pg = new ProductsAdd(driver);
        WebElement pageTitleElement = pg.CartTitleAppear();

        // Wait for the title to appear
        waitForElementToBeVisible(pageTitleElement, 10);

        try {
            String pageTitle = pageTitleElement.getText();
            System.out.println("Current Page Title: " + pageTitle);
            test.log(Status.INFO, "Page title fetched: " + pageTitle);

            // Verify title
            Assert.assertEquals(pageTitle, "Cart", "Title does not match!");
            test.log(Status.PASS, "Title assertion passed!");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error fetching page title: " + e.getMessage());
            System.out.println("Error: Unable to fetch page title. " + e.getMessage());
            Assert.fail("Test failed due to exception.");
        }

        test.log(Status.INFO, "Test case: DisplayCartPageTitleGetandAssert ended");
    }

    /**
     * Waits for an element to be visible before interacting with it.
     */
    private void waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

