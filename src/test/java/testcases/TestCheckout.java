package testcases;

import base.Base;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.ProductsAdd;

public class TestCheckout extends Base {

    @Test
    public void Checkout() throws InterruptedException {
        Thread.sleep(5000); // Wait for the page to load
        CartPage pg = new CartPage(driver);

        // Interact with the Name field
        pg.getNameField().sendKeys("Hasan al mamun");

        pg.getLetsShopButton().click();

        pg.ClickAddToCart1().click();

        pg.ClickAddToCart2().click();

        pg.ClickCartButton().click();

        pg.ClickCheckBoxX().click();

        pg.ClickCheckoutButton().click();

        pg.ClickSearchBar().click();
        Thread.sleep(3000);


    }

}

