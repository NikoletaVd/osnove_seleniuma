package d03_02_2023;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class KatalonShopTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://cms.demo.katalon.com";

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }

    @Test(priority = 10)
    @Description("Adding product with quantity to the cart")
    public void addingProductToTheCart() {
        driver.get(baseUrl + "/product/flying-ninja/");
        driver.findElement(By.className("quantity-up")).click();
        driver.findElement(By.className("quantity-up")).click();
        driver.findElement(By.name("add-to-cart")).click();
        Assert.assertTrue(driver.findElement(By.className("woocommerce-message")).getText().contains("Flying Ninja"),
                "Message does not match.");
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/cart/']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"), "Not on Cart page.");
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("woocommerce-cart-form"), 1));

    }

    @Test (priority = 20)
    @Description ("Removing product from cart")
    public void removingProductFromCart() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/cart/']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"), "Not on Cart page.");
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("woocommerce-cart-form"), 1));
        driver.findElement(By.className("remove")).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("woocommerce-cart-form"), 0));
    }

    @Test (priority = 30)
    @Description ("Verify error is displayed when username is missing")
    public void errorIsDisplayedWhenUsernameIsMissing() {
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.name("login")).click();
        Assert.assertEquals(driver.findElement(By.className("woocommerce-error")).getText(), "Error: Username is required.",
                "Message does not match.");
    }

    @Test (priority = 40)
    @Description ("Verify error is displayed when password is missing")
    public void errorIsDisplayedWhenPasswordIsMissing() {
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.name("login")).click();
        Assert.assertEquals(driver.findElement(By.className("woocommerce-error")).getText(),
                "ERROR: The password field is empty.", "Message does not match.");
    }
    @Test (priority = 50)
    @Description ("Verify error is displayed when password is wrong")
    public void errorIsDisplayedWhenPasswordIsWrong() {
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.id("password")).sendKeys("invalidpassword");
        driver.findElement(By.name("login")).click();
        Assert.assertEquals(driver.findElement(By.className("woocommerce-error")).getText(),
                "ERROR: The password you entered for the username customer is incorrect. Lost your password?",
                "Message does not match.");
    }
    @Test (priority = 60)
    @Description ("Verify error is displayed when user does not exist")
    public void errorIsDisplayedWhenUserDoesntExist() {
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.id("username")).sendKeys("invaliduser");
        driver.findElement(By.id("password")).sendKeys("pass1234");
        driver.findElement(By.name("login")).click();
        Assert.assertEquals(driver.findElement(By.className("woocommerce-error")).getText(),
                "ERROR: Invalid username. Lost your password?",
                "Message does not match.");
    }
    @Test (priority = 70)
    @Description ("Verify successful login")
    public void successfulLogin() {
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/my-account/']")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.id("password")).sendKeys("crz7mrb.KNG3yxv1fbn");
        driver.findElement(By.name("login")).click();
        Assert.assertTrue(driver.findElement(By.className("entry-content")).getText().
                contains("Hello Katalon Parlitul_Changed"), "Message does not match.");
    }

    @AfterMethod
    public void afterMethod() {
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
