package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com/");
        WebElement selectEl = driver.findElement(By.id("gh-cat"));

        Select select = new Select(selectEl);
        select.selectByValue("2984");

        Thread.sleep(5000);
        driver.quit();

    }
}
