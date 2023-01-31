package p27_01_2023;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Uvod {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/nikoletanojic/Downloads/Zadatak4.html");

//        driver.findElement(By.id("showInBtn"));

//        I NACIN
        boolean elementExist = true;

        try {
            WebElement div = driver.findElement(By.id("id-0"));
        } catch (NoSuchElementException error) {
            elementExist = false;
        }
        if (elementExist) {
            System.out.println("Element postoji.");
        } else {
            System.out.println("Element ne postoji.");
        }


//        II NACIN
        Helper helper = new Helper();
        if(helper.elementExist(driver, By.id("id-0"))) {
            System.out.println("Postoji");
        } else {
            System.out.println("Ne postoji");
        }


//      III NACIN
        List<WebElement> divs = driver.findElements(By.id("id-0"));
        if (divs.size() > 0) {
            System.out.println();
        } else {
            System.out.println();
        }


        Thread.sleep(5000);
        driver.quit();


    }
}
