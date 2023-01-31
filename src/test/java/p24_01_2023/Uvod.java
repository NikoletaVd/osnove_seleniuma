package p24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Uvod {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

//        driver.get("");
        driver.manage().window().maximize();
//        driver.manage().window().minimize();

        driver.get("http://google.com/");
//        driver.get("http://youtube.com/");
//        driver.get("http://google.com/");
//        driver.navigate().back();
//        driver.navigate().forward();

        String imgAttr = driver.findElement(By.xpath("//img[@class='lnXdpd']")).getAttribute("src");
        System.out.println(imgAttr);

//        Thread.sleep(5000);
//        WebElement searchInput = driver.findElement(By.xpath("//input[@name='q']"));
//        searchInput.sendKeys("IT Bootcamp");
//        searchInput.sendKeys(Keys.ENTER);
//        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("IT Bootcamp");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
        long startTime = System.currentTimeMillis();
        long duration = System.currentTimeMillis() - startTime;

//        WebElement firstLink = driver.findElement(By.xpath("//a[@href='https://itbootcamp.rs/']"));
//        firstLink.click();
        driver.findElement(By.xpath("//a[@href='https://itbootcamp.rs/']")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}
