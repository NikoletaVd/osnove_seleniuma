package d26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji ucitava stranicu https://geodata.solutions/
//        Bira Country, State i City po vasoj zelji
//        Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//        I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//        Izabrerit Country, State i City tako da imate podatke da selektujete!

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://geodata.solutions/");

        WebElement selectCountry = driver.findElement(By.name("country"));
        Select select1 = new Select(selectCountry);
        select1.selectByValue("Australia");
        Thread.sleep(3000);

        WebElement selectState = driver.findElement(By.name("state"));
        Select select2 = new Select(selectState);
        select2.selectByValue("Queensland");
        Thread.sleep(3000);

        WebElement selectCity = driver.findElement(By.name("city"));
        Select select3 = new Select(selectCity);
        select3.selectByValue("Allora");

        Thread.sleep(5000);
        driver.quit();

    }
}
