package p02_02_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class KatalonLoginTests {

//    Kreirati klasu KatalonLoginTests za testove
//    Base url: https://cms.demo.katalon.com
//    Test #1: Visit login page from Nav bar
//    Koraci:
//    Ucitati home stranicu
//    Kliknuti na My account link
//    Verifikovati da je naslov stranice My account – Katalon Shop
//    Verifikovati da se u url-u stranice javlja /my-account
//    Za sve validacije ispisati odgovarajuce poruke u slucaju greske

    private WebDriver driver;
    private WebDriverWait wait;

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
        driver.get("https://cms.demo.katalon.com");
    }
    @Test
    public void visitLoginPageFromNavBar() {
        driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/my-account/']")).click();
        Assert.assertEquals(driver.getTitle(), "My account – Katalon Shop", "Homepage header does not match.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "URL does not match.");
    }

    @Test
    public void checkInputTypes() {
        driver.get("https://cms.demo.katalon.com/my-account/");
        Assert.assertEquals(driver.findElement
                (By.xpath("//input[@type='text']")).getAttribute("type"), "text",
                "Value does not match.");
        Assert.assertEquals(driver.findElement(By.name("password")).getAttribute("type"), "password",
                "Value does not match.");
        Assert.assertEquals(driver.findElement(By.name("rememberme")).getAttribute("type"), "checkbox",
                "Value does not match.");
        WebElement checkbox = driver.findElement(By.name("rememberme"));
        Assert.assertFalse(checkbox.isSelected(), "Checkbox should not be selected.");
    }
    @Test
    public void displayErrorWhenCredentialsAreWrong() {
        driver.get("https://cms.demo.katalon.com/my-account/");
        driver.findElement(By.id("username")).sendKeys("invalidemail@gmail.com");
        driver.findElement(By.name("password")).sendKeys("invalid123");
        driver.findElement(By.name("login")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@role='alert']")).isDisplayed(),
                "Error message is not displayed.");
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@role='alert']/li/strong")).getText(),"ERROR: Invalid email address.",
                "Message does not match.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "URL does not match.");
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
