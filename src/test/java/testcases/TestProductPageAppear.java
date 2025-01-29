//package testcases;
//
//import base.Base;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import pageObjects.ProductsPage;
//import org.openqa.selenium.WebElement;
//
//public class TestProductPageAppear extends Base {
//
//    @Test
//    public void ProductPageAppear() throws InterruptedException {
////        Thread.sleep(5000); // Wait for the page to load
//        ProductsPage pg = new ProductsPage(driver);
//
//        // Interact with the Name field
//        pg.getNameField().sendKeys("Hasan al mamun");
//
//        pg.getLetsShopButton().click();
//        Thread.sleep(3000);
//    }
//
//
//
//    @Test
//    public void ProductPageAppearTitleGetPrint() throws InterruptedException {
//
//        ProductPageAppear();
//        ProductsPage pg = new ProductsPage(driver);
//        WebElement pageTitleElement = pg.ProductsTitleAppear();
//        // Fetch and print the title of the Products page
//        try {
// // Assuming this locator gets the title element
//            String pageTitle = pageTitleElement.getText(); // Fetch the text of the title element
//            System.out.println("Current Page Title: " + pageTitle);
//        } catch (Exception e) {
//            System.out.println("Error: Unable to fetch page title. " + e.getMessage());
//        }
//
//
//        String actualTitle = pageTitleElement.getText();
//        String expectedTitle = "Products";
//        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
//        System.out.println("Title assertion passed!");
//
//    }
//}
//

package testcases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ProductsPage;
import com.aventstack.extentreports.Status;

import java.time.Duration;

public class TestProductPageAppear extends Base {

    @Test
    public void ProductPageAppear() {
        test.log(Status.INFO, "Test case: ProductPageAppear started");

        ProductsPage pg = new ProductsPage(driver);

        // Enter name
        WebElement nameField = pg.getNameField();
        waitForElementToBeVisible(nameField, 10);
        nameField.sendKeys("Hasan al mamun");
        test.log(Status.INFO, "Entered name: Hasan al mamun");

        // Click on 'Let's Shop' button
        WebElement shopButton = pg.getLetsShopButton();
        waitForElementToBeVisible(shopButton, 10);
        shopButton.click();
        test.log(Status.INFO, "Clicked on Let's Shop button");

        test.log(Status.PASS, "ProductPageAppear test passed");
    }

    @Test(dependsOnMethods = "ProductPageAppear")
    public void ProductPageAppearTitleGetPrint() {
        test.log(Status.INFO, "Test case: ProductPageAppearTitleGetPrint started");

        ProductsPage pg = new ProductsPage(driver);
        WebElement pageTitleElement = pg.ProductsTitleAppear();

        // Wait for the title to appear
        waitForElementToBeVisible(pageTitleElement, 10);

        try {
            String pageTitle = pageTitleElement.getText();
            System.out.println("Current Page Title: " + pageTitle);
            test.log(Status.INFO, "Page title fetched: " + pageTitle);

            // Verify title
            Assert.assertEquals(pageTitle, "Products", "Title does not match!");
            test.log(Status.PASS, "Title assertion passed!");
        } catch (Exception e) {
            test.log(Status.FAIL, "Error fetching page title: " + e.getMessage());
            System.out.println("Error: Unable to fetch page title. " + e.getMessage());
            Assert.fail("Test failed due to exception.");
        }

        test.log(Status.INFO, "Test case: ProductPageAppearTitleGetPrint ended");
    }

    /**
     * Waits for an element to be visible before interacting with it.
     */
    private void waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

