package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class UvodUListu {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://cms.demo.katalon.com/");
        List<WebElement> navLinks = driver.findElements(By.xpath("//*[@id='primary-menu']/ul/li/a"));

        for (int i = 0; i < navLinks.size(); i++) {
            String tekst = navLinks.get(i).getText();
            System.out.println(tekst);
        }

        List<WebElement> imgs = driver.findElements(By.xpath("//li[contains(@class, 'product')]/div/a/img"));

        for (int i = 0; i < imgs.size(); i++) {
            System.out.println(imgs.get(i).getAttribute("src"));

        }

        List<WebElement> products = driver.findElements(By.className("product"));
        for (int i = 0; i < products.size(); i++) {
            WebElement img = products.get(i).findElement(By.tagName("img"));
            System.out.println(img.getAttribute("src"));

        }



        Thread.sleep(5000);
        driver.quit();

    }
}
