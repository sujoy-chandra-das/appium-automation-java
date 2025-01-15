package testcases;

import pageObjects.HomePage;
import base.Base;
import org.testng.annotations.Test;
import pageObjects.ProductsPage;

public class ProductPageAppear extends Base {

    @Test // Test method to run the test
    public void ProductPageAppear() throws InterruptedException {

        Thread.sleep(5000); // Wait for the page to load
        ProductsPage pg = new ProductsPage(driver);

//        pg.ClickCountrydropdownIcon().click();
//        Thread.sleep(3000);
//
//        pg.SelectCountry().click();
//        Thread.sleep(3000);



        // Interact with the Name field
        pg.getNameField().sendKeys("Hasan al mamun");
        Thread.sleep(5000); // Wait for any action to take effect

        pg.getGender().click();
        Thread.sleep(3000);

        pg.getLetsShopButton().click();
        Thread.sleep(3000);
    }


}
