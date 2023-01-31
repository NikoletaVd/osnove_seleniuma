package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://cms.demo.katalon.com/");

        if (driver.findElement(By.className("menu-toggle")).isDisplayed()) {
            System.out.println("Vidi se.");
        } else {
            System.out.println("Ne vidi se.");
        }

        driver.manage().window().setSize(new Dimension(700, 700));
        if (driver.findElement(By.className("menu-toggle")).isDisplayed()) {
            System.out.println("Vidi se.");
        } else {
            System.out.println("Ne vidi se.");
        }
        Thread.sleep(5000);
        driver.quit();


    }
}
