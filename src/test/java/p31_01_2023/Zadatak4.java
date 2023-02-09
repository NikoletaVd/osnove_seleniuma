package p31_01_2023;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
//        Kreirati screenshots folder u projektu
//        Ucitava stranicu https://cms.demo.katalon.com/
//        Kreira screenshot stranice
//        Sacuvati screenshot u folderu screenshots pod imenom screenshot1.jpg


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://cms.demo.katalon.com/");
        driver.manage().window().maximize();

        try {
            new Helper().takeScreenshot(driver, "screenshots/screenshot1.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(5000);
        driver.quit();

    }
}
