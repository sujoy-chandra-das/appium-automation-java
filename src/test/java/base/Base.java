package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
    public static ExtentReports extent;
    public ExtentTest test;

    @BeforeTest // Open the session
    public void setup() throws MalformedURLException {
        // Initialize ExtentReports only once before running any tests
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/reports/TestReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }

        // Set up Appium server and desired capabilities
        String appiumServerUrl = "http://127.0.0.1:4723";
        String apkPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "General-Store.apk";

        // Log APK Path to ensure it's correct
        System.out.println("APK Path: " + apkPath);

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "uiautomator2");
        dc.setCapability("appium:app", apkPath);
    }

    @BeforeMethod // Start a new test
    public void startTest(Method method) throws MalformedURLException {
        // Initialize the driver before each test if it's not already initialized
        if (driver == null) {
            String appiumServerUrl = "http://127.0.0.1:4723";
            String apkPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "General-Store.apk";

            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability("platformName", "Android");
            dc.setCapability("appium:automationName", "uiautomator2");
            dc.setCapability("appium:app", apkPath);

            try {
                driver = new AndroidDriver(new URL(appiumServerUrl), dc); // Initialize AndroidDriver
                if (driver == null) {
                    throw new RuntimeException("Driver initialization failed. Driver is null.");
                }
                System.out.println("Driver initialized successfully.");
            } catch (MalformedURLException e) {
                throw new MalformedURLException("Error while starting Appium session: " + e.getMessage());
            }
        }

        // Initialize WebDriverWait with a default timeout of 20 seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));  // Increased timeout for slow loading elements

        // Ensure the ExtentReports object is initialized before starting the test
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/reports/TestReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }

        // Create a new test entry for Extent Reports
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
    }

    @AfterTest // Close the session
    public void close() {
        if (driver != null) {
            try {
                driver.quit(); // Properly quit the driver session
                System.out.println("Driver session closed.");
            } catch (Exception e) {
                System.out.println("Error while quitting driver: " + e.getMessage());
            }
        }
        if (extent != null) {
            extent.flush(); // Only one flush at the end to finalize the report
        }
    }

    // Helper method to ensure an element is visible and ready for interaction
    public WebElement waitForElementVisibility(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));  // Increased timeout for visibility
    }
}
