package testcases;
import pageObjects.HomePage;
import base.Base;
import org.testng.annotations.Test;

public class testing extends Base {

    @Test // Test method to run the test
    public void testPermissionAllow() throws InterruptedException {
        // Wait for 10 seconds to allow the screen to load (use explicit wait for better practice)
        Thread.sleep(3000);

    HomePage hp = new HomePage(driver);

    hp.nameField.sendKeys("Hasan al mamun");
    Thread.sleep(5000);


    }























}
