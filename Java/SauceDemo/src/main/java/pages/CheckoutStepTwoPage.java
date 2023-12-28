package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage {
    WebDriver driver;

    By finish_btn = By.id("finish");

    public CheckoutStepTwoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFinishButton() {
        driver.findElement(finish_btn).click();
    }
}
