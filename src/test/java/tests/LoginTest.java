package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Test
    public void testValidLogin() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login failed!");
    }

    @Test
    public void testInvalidLogin() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.login("wrong_user", "wrong_pass");
        Assert.assertTrue(driver.getPageSource().contains("Epic sadface"), "Error message not displayed!");
    }
}
