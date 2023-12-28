package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    WebDriver driver;

    By back_to_products_btn = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBackToProductsButton() {
        driver.findElement(back_to_products_btn).click();
    }
}
