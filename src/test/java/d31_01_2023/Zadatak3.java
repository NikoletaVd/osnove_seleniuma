package d31_01_2023;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class Zadatak3 {
    public static void main(String[] args) throws IOException, InterruptedException {
//        Napisati program koji:
//        Ucitava stranicu https://itbootcamp.rs/
//        Skrola do slajdera na dnu stranice (u kome su slike Java, Php, Selenium, …)
//        Cita sve linkove slika iz slajdera
//        Proverava url svake slike, i za sve slike koje imaju status veci i jednak od 200 a manji od 300, skida i smesta u folder itbootcamp_slider u okviru projekta
//        Azurirajte gitignore da ignorise itbootcamp_slider folder

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://itbootcamp.rs/");
        driver.manage().window().maximize();
        new Actions(driver).scrollToElement(driver.findElement
                (By.xpath("//div[@class='vc_row wpb_row vc_row-fluid slider_bkgd']"))).perform();

        List<WebElement> links = driver.findElements(By.xpath("//div[@class='owl-stage']/div/div[@class='carousel-item']/img"));
        for (int i = 0; i < links.size(); i++) {
            String url = links.get(i).getAttribute("src");
            try {
                int statusCode = new Helper().getHTTPResponseStatusCode(url);
                if (statusCode >= 200 && statusCode < 300) {
                    try {
                        new Helper().downloadUsingStream(url, "itbootcamp_slider/slika" + i + ".jpg");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        Thread.sleep(5000);
        driver.quit();

    }
}
