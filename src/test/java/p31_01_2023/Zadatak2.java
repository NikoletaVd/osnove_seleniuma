package p31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//        Ucitava stranu https://blueimp.github.io/jQuery-File-Upload/
//        Uploadujte sliku
//        Ceka se da se pojavi slika u listi uploadovanih fajlova
//        Koristite uslov da broj elemenata bude 1.
//        Klik na Start dugme u okviru item-a koji se uploadovao
//        Ceka se da se pojavi delete dugme pored itema
//        Klik na delete dugme pored itema
//        Ceka se da se element obrise
//        Koristite da broj elemenata bude 0

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://blueimp.github.io/jQuery-File-Upload/ ");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@type='file']")).
                sendKeys(new File("test_data/red-square.jpg").getAbsolutePath());

        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("files"), 1));
        driver.findElement(By.className("btn-primary")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-type='DELETE']")));
        driver.findElement(By.xpath("//button[@data-type='DELETE']")).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("template-download"), 0));

        Thread.sleep(5000);
        driver.quit();

    }
}
