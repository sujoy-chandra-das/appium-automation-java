//package base;
//
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;

//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.time.Duration;
//
//public class Base {
//
//    public AndroidDriver driver;
//    public WebDriverWait wait;
//
//    @BeforeTest // Open the session
//    public void setup() throws MalformedURLException {
//        String appiumServerUrl = "http://127.0.0.1:4723";
//
//        // Get the path of the APK file in the project directory
//        String apkPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "General-Store.apk";
//
//        DesiredCapabilities dc = new DesiredCapabilities();
//        dc.setCapability("platformName", "Android");
//        dc.setCapability("appium:automationName", "uiautomator2");
//        dc.setCapability("appium:app", apkPath);
//        // Uncomment the following line if you want to auto-grant permissions
//        // dc.setCapability("autoGrantPermissions", true);
//
//        driver = new AndroidDriver(new URL(appiumServerUrl), dc);
//
//        // Initialize WebDriverWait with a default timeout of 20 seconds
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    }
//
//    @AfterTest // Close the session
//    public void close() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}

package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {

    public AndroidDriver driver;
    public WebDriverWait wait;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeTest // Open the session
    public void setup() throws MalformedURLException {
        String appiumServerUrl = "http://127.0.0.1:4723";

        // Get the path of the APK file in the project directory
        String apkPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "General-Store.apk";

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "Espresso");
        dc.setCapability("appium:app", apkPath);
        // Uncomment the following line if you want to auto-grant permissions
        // dc.setCapability("autoGrantPermissions", true);

        driver = new AndroidDriver(new URL(appiumServerUrl), dc);

        // Initialize WebDriverWait with a default timeout of 20 seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Initialize Extent Reports
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("path/to/report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @BeforeMethod // Start a new test
    public void startTest(Method method) {
        test = extent.createTest(method.getName());
    }

    @AfterMethod // End the test
    public void endTest(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed: " + result.getName());
            test.log(Status.FAIL, "Failure Reason: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case Passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
        }
        extent.flush();
    }

    @AfterTest // Close the session
    public void close() {
        if (driver != null) {
            driver.quit();
        }
        if (extent != null) {
            extent.flush();
        }
    }
}

