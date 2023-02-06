package d02_02_2023;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class BootstrapTableTests {
//    Kreirati BootstrapTableTests klasu koja ima:
//    Base url: https://s.bootsnipp.com
//    Test #1: Edit Row
//    Podaci:
//    First Name: ime polaznika
//    Last Name: prezime polaznika
//    Middle Name: srednje ime polanzika
//    Koraci:
//    Ucitati stranu /iframe/K5yrx
//    Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//    Klik na Edit dugme prvog reda
//    Sacekati da dijalog za Editovanje bude vidljiv
//    Popuniti formu podacima.
//    Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link
//    Klik na Update dugme
//    Sacekati da dijalog za Editovanje postane nevidljiv
//    Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//    Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//    Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//    Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//    Test #2: Delete Row
//    Podaci:
//    First Name: ime polaznika
//    Last Name: prezime polaznika
//    Middle Name: srednje ime polanzika
//    Koraci:
//    Ucitati stranu /iframe/K5yrx
//    Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//    Klik na Delete dugme prvog reda
//    Sacekati da dijalog za brisanje bude vidljiv
//    Klik na Delete dugme iz dijaloga
//    Sacekati da dijalog za Editovanje postane nevidljiv
//    Verifikovati da je broj redova u tabeli za jedan manji
//    Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//    Test #3: Take a Screenshot
//    Koraci:
//    Ucitati stranu  /iframe/K5yrx
//    Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//    Kreirati screenshot stranice.
//    Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: screenshots/slike.png

    private String baseUrl = "https://s.bootsnipp.com";
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
        driver.get(baseUrl);
    }

    @Test
    public void editRow() {
        driver.get(baseUrl + "/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
                "Title does not match.");
        driver.findElement(By.xpath("//button[@data-target='#edit'][@data-uid='1']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-dialog")));
        driver.findElement(By.id("fn")).clear();
        driver.findElement(By.id("ln")).clear();
        driver.findElement(By.id("mn")).clear();
        driver.findElement(By.id("fn")).sendKeys("Harry");
        driver.findElement(By.id("ln")).sendKeys("Potter");
        driver.findElement(By.id("mn")).sendKeys("James");
        driver.findElement(By.id("up")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-dialog")));
        Assert.assertEquals(driver.findElement(By.id("f1")).getText(), "Harry",
                "First name does not match.");
        Assert.assertEquals(driver.findElement(By.id("l1")).getText(), "Potter",
                "Last name does not match.");
        Assert.assertEquals(driver.findElement(By.id("m1")).getText(), "James",
                "Middle name does not match.");
    }
    @Test
    public void deleteRow() {
        driver.get(baseUrl + "/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
                "Title does not match.");
        driver.findElement(By.xpath("//button[@data-target='#delete'][@data-uid='1']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='delete']/div/div")));
        driver.findElement(By.id("del")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-dialog")));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table/tbody/tr"), 2));
    }
    @Test
    public void takeAScreenshot() {
        driver.get(baseUrl + "/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
                "Title does not match.");
        try {
            new Helper().takeScreenshot(driver,"screenshots/slika.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
