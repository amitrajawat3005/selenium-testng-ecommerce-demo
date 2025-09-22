package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.CartPage;
import utils.DriverManager;

import org.openqa.selenium.WebDriver;

public class CartTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;

    @BeforeMethod
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);

        // Login first
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login failed!");
    }

    @Test
    public void testAddAndRemoveFromCart() {
        homePage.addFirstItemToCart();
        homePage.goToCart();
        cartPage.removeItem();
        Assert.assertTrue(driver.getPageSource().contains("Continue Shopping"),
                "Item was not removed successfully!");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
