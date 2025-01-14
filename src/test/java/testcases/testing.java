//package testcases;
//
//import pageObjects.HomePage;
//import base.Base;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class testing extends Base {
//
//    @Test // Test method to run the test
//    public void HomepageAppear() throws InterruptedException {
//
//        Thread.sleep(10000); // Wait for the page to load
//        HomePage hp = new HomePage(driver);
//
//
//        // Interact with the Name field
//        hp.getNameField().sendKeys("Hasan al mamun");
//        Thread.sleep(5000); // Wait for any action to take effect
//
//
//    }
//}

package testcases;

import pageObjects.HomePage;
import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testing extends Base {

    @Test // Test method to run the test
    public void HomepageAppear() throws InterruptedException {

        Thread.sleep(10000); // Wait for the page to load
        HomePage hp = new HomePage(driver);

        // Check if the Name field is visible
        if (hp.getNameField().isDisplayed()) {
            System.out.println("getNameField is visible");
        } else {
            System.out.println("getNameField is not visible");
        }

        // Interact with the Name field
        hp.getNameField().sendKeys("Hasan al mamun");
        Thread.sleep(5000); // Wait for any action to take effect
    }
}
