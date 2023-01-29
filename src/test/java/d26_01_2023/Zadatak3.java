package d26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji:
//        Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//        Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element
//        obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//        POMOC: Brisite elemente odozdo.

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/Dq2X");

        List<WebElement> closeButtons = driver.findElements(By.xpath("//div[@class='col-md-12']/div/button"));

        for (int i = 0; i < closeButtons.size(); i++) {
            WebElement closeButton = closeButtons.get(i).findElement(By.className("//div[@class='col-md-12']/div/button[last()]"));
            closeButton.click();
        }
        Thread.sleep(5000);
        driver.quit();

    }
}
