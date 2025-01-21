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
        Thread.sleep(5000); // Wait for any action to take effect

        pg.getLetsShopButton().click();
        Thread.sleep(3000);

        pg.ClickAddToCart1().click();
        Thread.sleep(3000);

        pg.ClickAddToCart2().click();
        Thread.sleep(3000);

        pg.ClickCartButton().click();
        Thread.sleep(3000);

        pg.ClickCheckBoxX().click();
        Thread.sleep(3000);

        pg.ClickCheckoutButton().click();
        Thread.sleep(3000);

        pg.ClickSearchBar().click();
        Thread.sleep(3000);


    }

}

