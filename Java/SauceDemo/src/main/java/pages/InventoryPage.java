package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    WebDriver driver;

    By onesie_clothing_btn = By.id("add-to-cart-sauce-labs-onesie");
    By fleece_jacket_clothing_btn = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By shopping_cart_btn = By.id("shopping_cart_container");
    By react_burger_menu_btn = By.id("react-burger-menu-btn");
    By logout_btn = By.id("logout_sidebar_link");
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
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

    public void clickReactBurgerMenuButton() {
        driver.findElement(react_burger_menu_btn).click();
    }

    public void clickLogoutButton() {
        driver.findElement(logout_btn).click();
    }
}
