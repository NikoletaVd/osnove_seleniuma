package d26_01_2023;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
//        Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//        Visit Paris
//        Visit Prague
//        Visit London
//        Visit New York
//        Visit Belgrade
//        Maksimizirati prozor
//        Ucitati stranicu https://example.cypress.io/todo
//        Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//        Nakon svakog unosa todo-a, unosi se enter
//        Validira da li je novi todo dodat na stranici
//        Na kraju programa proci petljom i izbrisati svaki todo sa stranice (klikom na x dugme svakog todo-a)
//        Validirati da je na kraju programa broj todo-a na stranici 0.
//        Cekanje od 5s
//        Zatvorite pretrazivac

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        ArrayList<String> toDo = new ArrayList<>();
        toDo.add("Visit Paris");
        toDo.add("Visit Prague");
        toDo.add("Visit London");
        toDo.add("Visit New York");
        toDo.add("Visit Belgrade");

        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");

        for (int i = 0; i < toDo.size(); i++) {
            driver.findElement(By.className("new-todo")).sendKeys(toDo.get(i));
            driver.findElement(By.className("new-todo")).sendKeys(Keys.ENTER);
            try {
                driver.findElement(By.xpath("//ul[@class='todo-list']/li[" + (i + 1) + "]"));
                System.out.println("Dodat je novi todo.");
            } catch (NoSuchElementException error) {
                System.out.println("Nije dodat novi todo.");
            }
        }

        Actions actions = new Actions(driver);
        List<WebElement> webElements = driver.findElements((By.xpath("//button[contains(@class,'destroy')]")));
        webElements.forEach(element -> {
            actions.moveToElement(element.findElement(By.xpath("./.."))).build().perform();
            element.click();
        });

        Thread.sleep(5000);
        driver.quit();
    }
}
