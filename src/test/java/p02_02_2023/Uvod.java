package p02_02_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Uvod {

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
    public void beforeMethod(){
        driver.get("https://google.com/");
    }
    @Test
    public void googleTitleTest() throws InterruptedException {
        int numberOfLinks = driver.findElements(By.tagName("a")).size();
        Assert.assertEquals(numberOfLinks, 18, "Number of links on home page.");
//        Assert.assertEquals(driver.getTitle(), "Google");
    }

   @Test
    public void googleUrlTest() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://google.com/");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}