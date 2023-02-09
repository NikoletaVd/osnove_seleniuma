package p31_01_2023;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws IOException, InterruptedException {
//        Kreirati folder downloads folder u projektu
//        Ucitava stranu https://cms.demo.katalon.com/product/flying-ninja/
//        Cita href atribut sa glavne slike sa stranice
//        Koristi link iz href atributa za skidanje slike
//        Sliku sacuvajte u folderu downloads pod nazivom flying-ninja.jpg
//        Koristan link za skidanje fajlova u javi
//        Azurirajte gitignore da ignorise downloads folder

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://cms.demo.katalon.com/product/flying-ninja/");
        driver.manage().window().maximize();

        String imgSrc = driver.findElement(By.className("zoomImg")).getAttribute("src");

        try {
            new Helper().downloadUsingStream(imgSrc, "downloads/flying-ninja.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(5000);
        driver.quit();







    }
}
