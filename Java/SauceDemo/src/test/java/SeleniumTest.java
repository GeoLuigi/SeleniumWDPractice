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
        navigateTo("https://www.saucedemo.com/", driver);
        Assert.assertEquals(driver.findElement(By.id("user-name")).getAttribute ("placeholder"), "Username");
        Assert.assertEquals(driver.findElement(By.id("password")).getAttribute ("placeholder"), "Password");
        loginPage.setTextInUsernameBox("standard_user");
        loginPage.setTextInPasswordBox("secret_sauce");
        loginPage.clickLoginButton();

        // Inventory page
        assertCurrentUrl("https://www.saucedemo.com/inventory.html", driver);
        inventoryPage.clickOnesieClothingButton();
        inventoryPage.clickFleeceJacketClothingButton();
        inventoryPage.clickShoppingCartButton();

        // Cart page
        assertCurrentUrl("https://www.saucedemo.com/cart.html", driver);
        cartPage.clickCheckoutButton();

        // Checkout step one page
        assertCurrentUrl("https://www.saucedemo.com/checkout-step-one.html", driver);
        checkoutStepOnePage.setTextInFirstNameBox("JorgeTest");
        checkoutStepOnePage.setTextInLastNameBox("TestingGod");
        checkoutStepOnePage.setTextInPostalCodeBox("0000");
        checkoutStepOnePage.clickContinueButton();

        //Checkout step two page
        assertCurrentUrl("https://www.saucedemo.com/checkout-step-two.html", driver);
        checkoutStepTwoPage.clickFinishButton();

        // Checkout complete
        assertCurrentUrl("https://www.saucedemo.com/checkout-complete.html", driver);
        checkoutCompletePage.clickBackToProductsButton();

        // Products page (again)
        assertCurrentUrl("https://www.saucedemo.com/inventory.html", driver);
        inventoryPage.clickReactBurgerMenuButton();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

        inventoryPage.clickLogoutButton();

        // Login page (again)
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

        // Close browser
        driver.quit();
    }
    @Test
    public void LockedOutUserTest() {

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
        navigateTo("https://www.saucedemo.com/", driver);
        Assert.assertEquals(driver.findElement(By.id("user-name")).getAttribute ("placeholder"), "Username");
        Assert.assertEquals(driver.findElement(By.id("password")).getAttribute ("placeholder"), "Password");
        loginPage.setTextInUsernameBox("locked_out_user");
        loginPage.setTextInPasswordBox("secret_sauce");
        loginPage.clickLoginButton();

        // Inventory page
        assertCurrentUrl("https://www.saucedemo.com/inventory.html", driver);
        inventoryPage.clickOnesieClothingButton();
        inventoryPage.clickFleeceJacketClothingButton();
        inventoryPage.clickShoppingCartButton();

        // Cart page
        assertCurrentUrl("https://www.saucedemo.com/cart.html", driver);
        cartPage.clickCheckoutButton();

        // Checkout step one page
        assertCurrentUrl("https://www.saucedemo.com/checkout-step-one.html", driver);
        checkoutStepOnePage.setTextInFirstNameBox("JorgeTest");
        checkoutStepOnePage.setTextInLastNameBox("TestingGod");
        checkoutStepOnePage.setTextInPostalCodeBox("0000");
        checkoutStepOnePage.clickContinueButton();

        //Checkout step two page
        assertCurrentUrl("https://www.saucedemo.com/checkout-step-two.html", driver);
        checkoutStepTwoPage.clickFinishButton();

        // Checkout complete
        assertCurrentUrl("https://www.saucedemo.com/checkout-complete.html", driver);
        checkoutCompletePage.clickBackToProductsButton();

        // Products page (again)
        assertCurrentUrl("https://www.saucedemo.com/inventory.html", driver);
        inventoryPage.clickReactBurgerMenuButton();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

        inventoryPage.clickLogoutButton();

        // Login page (again)
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

        // Close browser
        driver.quit();
    }
    @Test
    public void ProblemUserTest() {

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
        navigateTo("https://www.saucedemo.com/", driver);
        Assert.assertEquals(driver.findElement(By.id("user-name")).getAttribute ("placeholder"), "Username");
        Assert.assertEquals(driver.findElement(By.id("password")).getAttribute ("placeholder"), "Password");
        loginPage.setTextInUsernameBox("problem_user");
        loginPage.setTextInPasswordBox("secret_sauce");
        loginPage.clickLoginButton();

        // Inventory page
        assertCurrentUrl("https://www.saucedemo.com/inventory.html", driver);
        inventoryPage.clickOnesieClothingButton();
        inventoryPage.clickFleeceJacketClothingButton();
        inventoryPage.clickShoppingCartButton();

        // Cart page
        assertCurrentUrl("https://www.saucedemo.com/cart.html", driver);
        cartPage.clickCheckoutButton();

        // Checkout step one page
        assertCurrentUrl("https://www.saucedemo.com/checkout-step-one.html", driver);
        checkoutStepOnePage.setTextInFirstNameBox("JorgeTest");
        checkoutStepOnePage.setTextInLastNameBox("TestingGod");
        checkoutStepOnePage.setTextInPostalCodeBox("0000");
        checkoutStepOnePage.clickContinueButton();

        //Checkout step two page
        assertCurrentUrl("https://www.saucedemo.com/checkout-step-two.html", driver);
        checkoutStepTwoPage.clickFinishButton();

        // Checkout complete
        assertCurrentUrl("https://www.saucedemo.com/checkout-complete.html", driver);
        checkoutCompletePage.clickBackToProductsButton();

        // Products page (again)
        assertCurrentUrl("https://www.saucedemo.com/inventory.html", driver);
        inventoryPage.clickReactBurgerMenuButton();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

        inventoryPage.clickLogoutButton();

        // Login page (again)
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

        // Close browser
        driver.quit();
    }
    @Test
    public void PerformanceGlitchUserTest() {

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
        navigateTo("https://www.saucedemo.com/", driver);
        Assert.assertEquals(driver.findElement(By.id("user-name")).getAttribute ("placeholder"), "Username");
        Assert.assertEquals(driver.findElement(By.id("password")).getAttribute ("placeholder"), "Password");
        loginPage.setTextInUsernameBox("performance_glitch_user");
        loginPage.setTextInPasswordBox("secret_sauce");
        loginPage.clickLoginButton();

        // Inventory page
        assertCurrentUrl("https://www.saucedemo.com/inventory.html", driver);
        inventoryPage.clickOnesieClothingButton();
        inventoryPage.clickFleeceJacketClothingButton();
        inventoryPage.clickShoppingCartButton();

        // Cart page
        assertCurrentUrl("https://www.saucedemo.com/cart.html", driver);
        cartPage.clickCheckoutButton();

        // Checkout step one page
        assertCurrentUrl("https://www.saucedemo.com/checkout-step-one.html", driver);
        checkoutStepOnePage.setTextInFirstNameBox("JorgeTest");
        checkoutStepOnePage.setTextInLastNameBox("TestingGod");
        checkoutStepOnePage.setTextInPostalCodeBox("0000");
        checkoutStepOnePage.clickContinueButton();

        //Checkout step two page
        assertCurrentUrl("https://www.saucedemo.com/checkout-step-two.html", driver);
        checkoutStepTwoPage.clickFinishButton();

        // Checkout complete
        assertCurrentUrl("https://www.saucedemo.com/checkout-complete.html", driver);
        checkoutCompletePage.clickBackToProductsButton();

        // Products page (again)
        assertCurrentUrl("https://www.saucedemo.com/inventory.html", driver);
        inventoryPage.clickReactBurgerMenuButton();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

        inventoryPage.clickLogoutButton();

        // Login page (again)
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

        // Close browser
        driver.quit();
    }
    @Test
    public void ErrorUserTest() {

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
        navigateTo("https://www.saucedemo.com/", driver);
        Assert.assertEquals(driver.findElement(By.id("user-name")).getAttribute ("placeholder"), "Username");
        Assert.assertEquals(driver.findElement(By.id("password")).getAttribute ("placeholder"), "Password");
        loginPage.setTextInUsernameBox("error_user");
        loginPage.setTextInPasswordBox("secret_sauce");
        loginPage.clickLoginButton();

        // Inventory page
        assertCurrentUrl("https://www.saucedemo.com/inventory.html", driver);
        inventoryPage.clickOnesieClothingButton();
        inventoryPage.clickFleeceJacketClothingButton();
        inventoryPage.clickShoppingCartButton();

        // Cart page
        assertCurrentUrl("https://www.saucedemo.com/cart.html", driver);
        cartPage.clickCheckoutButton();

        // Checkout step one page
        assertCurrentUrl("https://www.saucedemo.com/checkout-step-one.html", driver);
        checkoutStepOnePage.setTextInFirstNameBox("JorgeTest");
        checkoutStepOnePage.setTextInLastNameBox("TestingGod");
        checkoutStepOnePage.setTextInPostalCodeBox("0000");
        checkoutStepOnePage.clickContinueButton();

        //Checkout step two page
        assertCurrentUrl("https://www.saucedemo.com/checkout-step-two.html", driver);
        checkoutStepTwoPage.clickFinishButton();

        // Checkout complete
        assertCurrentUrl("https://www.saucedemo.com/checkout-complete.html", driver);
        checkoutCompletePage.clickBackToProductsButton();

        // Products page (again)
        assertCurrentUrl("https://www.saucedemo.com/inventory.html", driver);
        inventoryPage.clickReactBurgerMenuButton();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

        inventoryPage.clickLogoutButton();

        // Login page (again)
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

        // Close browser
        driver.quit();
    }
    @Test
    public void VisualUserTest() {

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
        navigateTo("https://www.saucedemo.com/", driver);
        Assert.assertEquals(driver.findElement(By.id("user-name")).getAttribute ("placeholder"), "Username");
        Assert.assertEquals(driver.findElement(By.id("password")).getAttribute ("placeholder"), "Password");
        loginPage.setTextInUsernameBox("visual_user");
        loginPage.setTextInPasswordBox("secret_sauce");
        loginPage.clickLoginButton();

        // Inventory page
        assertCurrentUrl("https://www.saucedemo.com/inventory.html", driver);
        inventoryPage.clickOnesieClothingButton();
        inventoryPage.clickFleeceJacketClothingButton();
        inventoryPage.clickShoppingCartButton();

        // Cart page
        assertCurrentUrl("https://www.saucedemo.com/cart.html", driver);
        cartPage.clickCheckoutButton();

        // Checkout step one page
        assertCurrentUrl("https://www.saucedemo.com/checkout-step-one.html", driver);
        checkoutStepOnePage.setTextInFirstNameBox("JorgeTest");
        checkoutStepOnePage.setTextInLastNameBox("TestingGod");
        checkoutStepOnePage.setTextInPostalCodeBox("0000");
        checkoutStepOnePage.clickContinueButton();

        //Checkout step two page
        assertCurrentUrl("https://www.saucedemo.com/checkout-step-two.html", driver);
        checkoutStepTwoPage.clickFinishButton();

        // Checkout complete
        assertCurrentUrl("https://www.saucedemo.com/checkout-complete.html", driver);
        checkoutCompletePage.clickBackToProductsButton();

        // Products page (again)
        assertCurrentUrl("https://www.saucedemo.com/inventory.html", driver);
        inventoryPage.clickReactBurgerMenuButton();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

        inventoryPage.clickLogoutButton();

        // Login page (again)
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

        // Close browser
        driver.quit();
    }

    private void navigateTo(String url, WebDriver driver) {
        driver.navigate().to(url);
    }

    private void assertCurrentUrl(String expectedUrl, WebDriver driver) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}