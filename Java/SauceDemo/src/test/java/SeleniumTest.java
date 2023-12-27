import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void LogInTest() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-blink-features=AutomationControlled");
        DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cap);

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 2);

        // Login page
        driver.navigate().to("https://www.saucedemo.com/");
        Assert.assertEquals(driver.findElement(By.id("user-name")).getAttribute ("placeholder"), "Username");
        Assert.assertEquals(driver.findElement(By.id("password")).getAttribute ("placeholder"), "Password");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();



        // Products page
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.id("shopping_cart_container")).click();

        // Shopping cart
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
        driver.findElement(By.id("checkout")).click();

        // Checkout
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
        driver.findElement(By.id("first-name")).sendKeys("JorgeTest");
        driver.findElement(By.id("last-name")).sendKeys("TestingGod");
        driver.findElement(By.id("postal-code")).sendKeys("0000");
        driver.findElement(By.id("continue")).click();

        //Checkout overview
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
        driver.findElement(By.id("finish")).click();

        // Checkout complete
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
        driver.findElement(By.id("back-to-products")).click();

        // Products page (again)
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        driver.findElement(By.id("react-burger-menu-btn")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

        driver.findElement(By.id("logout_sidebar_link")).click();

        // Login page (again)
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }
}