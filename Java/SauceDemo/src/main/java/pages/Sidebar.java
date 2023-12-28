package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sidebar {
    protected WebDriver driver;
    private final By react_burger_menu_btn = By.id("react-burger-menu-btn");
    private final By logout_btn = By.id("logout_sidebar_link");

    public Sidebar(WebDriver driver) {
        this.driver = driver;
    }

    public void clickReactBurgerMenuButton() {
        driver.findElement(react_burger_menu_btn).click();
    }

    public void clickLogoutButton() {
        driver.findElement(logout_btn).click();
    }
}
