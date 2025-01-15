//package testcases;
//
//import pageObjects.HomePage;
//import base.Base;
//import org.testng.annotations.Test;
//import pageObjects.ProductsPage;
//
//public class ProductPageAppear extends Base {
//
//    @Test // Test method to run the test
//    public void ProductPageAppear() throws InterruptedException {
//
//        Thread.sleep(5000); // Wait for the page to load
//        ProductsPage pg = new ProductsPage(driver);
//
////        pg.ClickCountrydropdownIcon().click();
////        Thread.sleep(3000);
////
////        pg.SelectCountry().click();
////        Thread.sleep(3000);
//
//
//
//        // Interact with the Name field
//        pg.getNameField().sendKeys("Hasan al mamun");
//        Thread.sleep(5000); // Wait for any action to take effect
//
////        pg.getGender().click();
////        Thread.sleep(3000);
//
//        pg.getLetsShopButton().click();
//        Thread.sleep(3000);
//
//
//      //Check if the Title is matched or fetched
////        if (pg.ProductsTitleAppear().isDisplayed()) {
////            System.out.println("Products page is successfully opened");
////        } else {
////            System.out.println("Products page is not successfully opened");
////        }
////        Thread.sleep(3000);
//
//
//
//
//
//    }
//
//
//}

package testcases;

import base.Base;
import org.testng.annotations.Test;
import pageObjects.ProductsPage;
import org.openqa.selenium.WebElement;

public class ProductPageAppear extends Base {

    @Test
    public void ProductPageAppear() throws InterruptedException {
        Thread.sleep(5000); // Wait for the page to load
        ProductsPage pg = new ProductsPage(driver);

        // Interact with the Name field
        pg.getNameField().sendKeys("Hasan al mamun");
        Thread.sleep(5000); // Wait for any action to take effect

        pg.getLetsShopButton().click();
        Thread.sleep(3000);

        // Fetch and print the title of the Products page
        try {
            WebElement pageTitleElement = pg.ProductsTitleAppear(); // Assuming this locator gets the title element
            String pageTitle = pageTitleElement.getText(); // Fetch the text of the title element
            System.out.println("Page Title: " + pageTitle);
        } catch (Exception e) {
            System.out.println("Error: Unable to fetch page title. " + e.getMessage());
        }

        // Verify if the Products page is displayed
        if (pg.ProductsTitleAppear().isDisplayed()) {
            System.out.println("Products page is successfully opened");
        } else {
            System.out.println("Products page is not successfully opened");
        }

        Thread.sleep(3000);
    }
}

