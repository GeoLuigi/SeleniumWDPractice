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
import pages.*;

public class SeleniumTest {

    @Test
    public void HappyPathTest() {

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

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        // Login page
        driver.navigate().to("https://www.saucedemo.com/");
        Assert.assertEquals(driver.findElement(By.id("user-name")).getAttribute ("placeholder"), "Username");
        Assert.assertEquals(driver.findElement(By.id("password")).getAttribute ("placeholder"), "Password");
        loginPage.setTextInUsernameBox("standard_user");
        loginPage.setTextInPasswordBox("secret_sauce");
        loginPage.clickLoginButton();

        // Inventory page
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        inventoryPage.clickOnesieClothingButton();
        inventoryPage.clickFleeceJacketClothingButton();
        inventoryPage.clickShoppingCartButton();

        // Cart page
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
        cartPage.clickCheckoutButton();

        // Checkout step one page
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
        checkoutStepOnePage.setTextInFirstNameBox("JorgeTest");
        checkoutStepOnePage.setTextInLastNameBox("TestingGod");
        checkoutStepOnePage.setTextInPostalCodeBox("0000");
        checkoutStepOnePage.clickContinueButton();

        //Checkout step two page
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
        checkoutStepTwoPage.clickFinishButton();

        // Checkout complete
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
        checkoutCompletePage.clickBackToProductsButton();

        // Products page (again)
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        inventoryPage.clickReactBurgerMenuButton();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

        inventoryPage.clickLogoutButton();

        // Login page (again)
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }
}