package d30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//        Zadatak (ZA VEZBANJE)
//        Modifikovati zadatak 1 tako da se skrol vrsi u vise iteracija, npr u 5

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");

        WebElement selectEl = driver.findElement(By.id("delay-select"));
        Select select = new Select(selectEl);
        select.selectByValue("2000");

        Thread.sleep(2000);

        for (int i = 0; i < 5; i++) {
            new Actions(driver).scrollToElement(driver.findElement(By.className("footer"))).perform();
            Thread.sleep(2000);

            new Actions(driver).scrollToElement
                    (driver.findElement(By.xpath("//div[contains(text(), 'C')]"))).perform();
            Thread.sleep(2000);

            new Actions(driver).scrollByAmount(0,1500).perform();
            Thread.sleep(1000);

            new Actions(driver).scrollToElement(driver.findElement(By.id("infinite-scroll-button"))).perform();
            Thread.sleep(2000);

            new Actions(driver).scrollToElement
                    (driver.findElement(By.xpath("//div[contains(text(), 'E')]"))).perform();
            Thread.sleep(2000);

            new Actions(driver).scrollToElement(driver.findElement(By.id("infinite-scroll-button"))).perform();

            wait.until(ExpectedConditions.elementToBeClickable(By.id("infinite-scroll-button")));
            Thread.sleep(2000);

            driver.findElement(By.id("infinite-scroll-button")).click();
        }

        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.id("infinite-scroll-button"))));

        Thread.sleep(5000);
        driver.quit();

    }
}
