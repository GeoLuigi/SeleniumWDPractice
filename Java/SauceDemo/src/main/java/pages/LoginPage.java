package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By username_box = By.id("user-name");
    By password_box = By.id("password");
    By login_btn = By.id("login-button");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setTextInUsernameBox(String text) {
        driver.findElement(username_box).sendKeys(text);
    }

    public void setTextInPasswordBox(String text) {
        driver.findElement(password_box).sendKeys(text);
    }

    public void clickLoginButton() {
        driver.findElement(login_btn).click();
    }
}
