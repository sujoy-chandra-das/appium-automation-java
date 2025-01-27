package testcases;

import pageObjects.HomePage;
import base.Base;
import org.testng.annotations.Test;

public class TestHomePageAppear extends Base {

    @Test // Test method to run the test
    public void HomepageAppear() throws InterruptedException {

        HomePage hp = new HomePage(driver);

        // Interact with the Name field
        hp.getNameField().sendKeys("Hasan al mamun");
        Thread.sleep(2000); // Wait for any action to take effect

        // Check if the Name field is visible
        if (hp.getNameField().isDisplayed()) {
            System.out.println("getNameField is visible");
        } else {
            System.out.println("getNameField is not visible");
        }

    }


}
