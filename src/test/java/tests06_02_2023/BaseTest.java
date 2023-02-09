package tests06_02_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.DeleteDialogPage;
import pages.EditDialogPage;
import pages.TablePage;
import pages06_02_2023.CartPage;
import pages06_02_2023.NavPage;
import pages06_02_2023.ProductPage;

import java.time.Duration;

public abstract class BaseTest {
    protected String baseUrl = "https://cms.demo.katalon.com";
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected CartPage cartPage;
    protected NavPage navPage;
    protected ProductPage productPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        cartPage = new CartPage(wait, driver);
        navPage = new NavPage(wait, driver);
        productPage = new ProductPage(wait, driver);
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
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
