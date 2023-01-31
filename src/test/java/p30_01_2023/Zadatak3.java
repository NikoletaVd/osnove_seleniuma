package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji
//        ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//        Klik Primary dugme
//        Ceka da se pojavi toasts u gornjem desnom uglu
//        Ispisuje da se element pojavio
//        Ceka da se izgubi toasts u gornjem desnom uglu
//        Ispisuje da se elment izgubio
//        Klik na primary dugme
//        Ceka da se pojavi toasts u gornjem desnom uglu
//        Ispisuje da se element pojavio
//        Klik na x dugme iz toasts-a
//        Ceka da se element izgubi
//        Ispisuje da se element izgubio

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        driver.findElement(By.id("basic-primary-trigger")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("basic-primary-example")));
        System.out.println("Element se pojavio.");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("basic-primary-example")));
        System.out.println("Element se izgubio.");

        driver.findElement(By.id("basic-primary-trigger")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("basic-primary-example")));
        System.out.println("Element se pojavio.");

        driver.findElement(By.id("basic-primary-example")).findElement(By.className("btn-close")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("basic-primary-example")));
        System.out.println("Element se izgubio.");

        Thread.sleep(5000);
        driver.quit();

    }
}
