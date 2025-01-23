package testcases;

import base.Base;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ProductsAdd;


public class TestProducts extends Base {

    @Test
    public void Products() throws InterruptedException {
        Thread.sleep(5000); // Wait for the page to load
        ProductsAdd pg = new ProductsAdd(driver);

        // Interact with the Name field
        pg.getNameField().sendKeys("Hasan al mamun");
        pg.getLetsShopButton().click();
        pg.ClickAddToCart1().click();
        pg.ClickAddToCart2().click();
        pg.ClickCartButton().click();

        WebElement pageTitleElement = pg.CartTitleAppear();
        // Fetch and print the title of the Products page
        try {
            // Assuming this locator gets the title element
            String pageTitle = pageTitleElement.getText(); // Fetch the text of the title element
            System.out.println("Current Page Title: " + pageTitle);
        } catch (Exception e) {
            System.out.println("Error: Unable to fetch page title. " + e.getMessage());
        }


        String actualTitle = pageTitleElement.getText();
        String expectedTitle = "Cart";
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
        System.out.println("Title assertion passed!");


        Thread.sleep(3000);


    }
}

