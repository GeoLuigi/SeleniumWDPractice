package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends Sidebar{

    By first_name_box = By.id("first-name");
    By last_name_box = By.id("last-name");
    By postal_code_box = By.id("postal-code");
    By continue_btn = By.id("continue");


    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public void setTextInFirstNameBox(String text) {
        driver.findElement(first_name_box).sendKeys(text);
    }

    public void setTextInLastNameBox(String text) {
        driver.findElement(last_name_box).sendKeys(text);
    }

    public void setTextInPostalCodeBox(String text) {
        driver.findElement(postal_code_box).sendKeys(text);
    }

    public void clickContinueButton() {
        driver.findElement(continue_btn).click();
    }
}
