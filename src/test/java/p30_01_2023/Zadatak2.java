package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji ucitava stranicu https://youtube.com i u search baru unosi tekste Breskvica
//        // i ceka da se pojavi vise od 3 rezultata iz padajuceg menija i zatim klikce na prvi.

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://youtube.com");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("EKV");
        driver.findElement(By.xpath("//input[@id='search']")).click();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.SPACE);

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='sbdd_b']/div/ul/li"),
                3));

        driver.findElements(By.xpath("//div[@class='sbdd_b']/div/ul/li")).get(0).click();

        Thread.sleep(5000);
        driver.quit();





    }
}
