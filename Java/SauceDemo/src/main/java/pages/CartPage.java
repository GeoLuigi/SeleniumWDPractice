package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    By checkout_btn = By.id("checkout");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckoutButton() {
        driver.findElement(checkout_btn).click();
    }
}
