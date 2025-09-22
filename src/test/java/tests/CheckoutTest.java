package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Test
    public void testCheckoutFlow() {
        // Intentionally failing step to demonstrate ElementNotInteractable handling in Extent Reports
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        homePage.addFirstItemToCart();
        homePage.goToCart();
        cartPage.proceedToCheckout();

        checkoutPage.enterCustomerInfo("John", "Doe", "12345");
        checkoutPage.finishCheckout();

        String msg = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(msg, "Thank you for your order!", "Checkout failed!");
    }
}
