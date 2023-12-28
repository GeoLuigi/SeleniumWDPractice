package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends Sidebar {

    By onesie_clothing_btn = By.id("add-to-cart-sauce-labs-onesie");
    By fleece_jacket_clothing_btn = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By shopping_cart_btn = By.id("shopping_cart_container");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnesieClothingButton() {
        driver.findElement(onesie_clothing_btn).click();
    }

    public void clickFleeceJacketClothingButton() {
        driver.findElement(fleece_jacket_clothing_btn).click();
    }

    public void clickShoppingCartButton() {
        driver.findElement(shopping_cart_btn).click();
    }
}
