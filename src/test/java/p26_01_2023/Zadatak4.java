package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
//        Zadatak
//        Napisati program koji ucitava stranicu http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.
//        Na kraju programa proverite da li je element cekiran. Izguglajte kako mozemo da proverimo da li
//        je element cekiran.
//
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://cms.demo.katalon.com/my-account/");

        driver.findElement(By.id("rememberme")).click();
        if (driver.findElement(By.id("rememberme")).isSelected()) {
            System.out.println("Cekirano je.");
        } else {
            System.out.println("Nije cekirano.");
        }
        Thread.sleep(5000);
        driver.quit();




    }
}
