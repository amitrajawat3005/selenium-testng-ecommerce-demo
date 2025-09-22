package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.DriverManager;
import utils.ExtentManager;
import utils.ScreenshotUtil;

import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void startReport() {
        extent = ExtentManager.getInstance();
    }

    @AfterSuite
    public void endReport() {
        extent.flush();
    }

    @BeforeMethod
    public void setup(Method method) {
        driver = DriverManager.getDriver();
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            // Capture screenshot
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());
            test.fail(result.getThrowable())
                    .addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else {
            test.skip("Test Skipped");
        }
        DriverManager.quitDriver();
    }

}
