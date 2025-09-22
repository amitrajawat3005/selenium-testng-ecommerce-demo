package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    private By checkoutBtn = By.id("checkout");
    private By removeBtn = By.xpath("(//button[text()='Remove'])[1]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void removeItem() {
        driver.findElement(removeBtn).click();
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
