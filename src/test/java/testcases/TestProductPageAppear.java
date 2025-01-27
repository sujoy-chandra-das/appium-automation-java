package testcases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ProductsPage;
import org.openqa.selenium.WebElement;

public class TestProductPageAppear extends Base {

    @Test
    public void ProductPageAppear() throws InterruptedException {
//        Thread.sleep(5000); // Wait for the page to load
        ProductsPage pg = new ProductsPage(driver);

        // Interact with the Name field
        pg.getNameField().sendKeys("Hasan al mamun");

        pg.getLetsShopButton().click();
        Thread.sleep(3000);
    }



    @Test
    public void ProductPageAppearTitleGetPrint() throws InterruptedException {

        ProductPageAppear();
        ProductsPage pg = new ProductsPage(driver);
        WebElement pageTitleElement = pg.ProductsTitleAppear();
        // Fetch and print the title of the Products page
        try {
 // Assuming this locator gets the title element
            String pageTitle = pageTitleElement.getText(); // Fetch the text of the title element
            System.out.println("Current Page Title: " + pageTitle);
        } catch (Exception e) {
            System.out.println("Error: Unable to fetch page title. " + e.getMessage());
        }


        String actualTitle = pageTitleElement.getText();
        String expectedTitle = "Products";
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
        System.out.println("Title assertion passed!");

    }
}

