package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji ucitava stranicu https://s.bootsnipp.com/iframe/klDWV i ceka da se
//        ucita progress bar na 100% a zatim ispisuje tekst u konzoli “Stranica ucitana”

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://s.bootsnipp.com/iframe/klDWV");

//        driver.findElement(By.xpath("//div[@class='loadbar']"));

        wait.until(ExpectedConditions.attributeContains(By.xpath("//div[@class='loadbar']"),
                "style", "width: 100%;"));

        System.out.println("Stranica je ucitana.");

        Thread.sleep(5000);
        driver.quit();

    }
}
