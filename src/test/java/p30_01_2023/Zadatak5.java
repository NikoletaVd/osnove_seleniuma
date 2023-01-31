package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji:
//        Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//        Vrsi klik na Primary dugme, Secondary, Sucess, Danger
//        Ceka da broj toasts-a bude 4
//        Ispisuje poruku, toasts su prikazani
//        Ceka da broj toasts-a bude 0
//        Ispisuje poruku, toasts su se izgubili

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        //        driver.findElement(By.xpath("//div/button[@id='basic-primary-trigger']")).click();
        driver.findElement(By.className("btn-primary")).click();
        driver.findElement(By.className("btn-secondary")).click();
        driver.findElement(By.className("btn-success")).click();
        driver.findElement(By.className("btn-danger")).click();

        wait.until(ExpectedConditions.
                numberOfElementsToBe
                        (By.xpath("//div[contains(@class, 'toast-fixed')][contains(@class, 'show')]"), 4));


        Thread.sleep(5000);
        driver.quit();

    }
}
