package p31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
//        Krairajte folder za fajlove u okviru projekta pod nazivom test_data
//        U folder skinite i postavite proizvoljnu sliku
//        Ucitava stranu https://tus.io/demo.html
//        Skrola do dela za upload fajla
//        Aploadujte sliku
//        Cekajte da se pojava dugme za download fajla


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tus.io/demo.html");


        new Actions(driver).scrollToElement(driver.findElement(By.xpath("//input[@type='file']"))).perform();
        driver.findElement(By.xpath("//input[@type='file']")).
                sendKeys(new File("test_data/red-square.jpg").getAbsolutePath());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("button-primary")));

        Thread.sleep(5000);
        driver.quit();
    }
}
