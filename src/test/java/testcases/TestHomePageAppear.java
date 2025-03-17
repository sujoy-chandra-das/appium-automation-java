package testcases;

import pageObjects.HomePage;
import base.Base;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

public class TestHomePageAppear extends Base {

    @Test // Test method to run the test
    public void HomepageAppear() throws InterruptedException {
        test.log(Status.INFO, "Test case: HomepageAppear started");

        HomePage hp = new HomePage(driver);

        // Interact with the Name field
        hp.getNameField().sendKeys("Hasan al mamun");
        test.log(Status.INFO, "Entered name: Hasan al mamun");
        Thread.sleep(2000); // Wait for any action to take effect

        // Check if the Name field is visible
        if (hp.getNameField().isDisplayed()) {
            test.log(Status.PASS, "getNameField is visible");
            System.out.println("getNameField is visible");
        } else {
            test.log(Status.FAIL, "getNameField is not visible");
            System.out.println("getNameField is not visible");
        }

        test.log(Status.INFO, "Test case: HomepageAppear ended");
    }
}
