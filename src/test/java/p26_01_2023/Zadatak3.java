package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
//        Napisti program koji:
//        Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//        Hvata sve elemente iz tabele i stampa tekst svakog elementa. Kako da od nekog elementa procitamo
//        tekst imate na sledecem linku
//        Ceka 5s
//        Zatvara pretrazivac
//        Stampa treba da bude kao u primeru:
//        John	Doe	john@example.com
//        Mary	Moe	mary@example.com
//        July	Dooley	july@example.com
//
//        HINT: bice vam lakse da radite ulancano trazenje. findElement().findELement()...

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://s.bootsnipp.com/iframe/z80en");

//
        WebElement table = driver.findElement(By.xpath("//*[@id='lorem']/table"));
//        for (int i = 1; i < 4; i++) {
//            for (int j = 1; j < 4; j++) {
//                String column = table.findElement(By.xpath("//tbody/tr["+i+"]/td["+j+"]")).getText();
//                System.out.print(column + "\t");
//            }
//            System.out.println();
//    }
        List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));

        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < columns.size(); j++) {
                System.out.print(columns.get(j).getText() + "\t");
            }
            System.out.println();
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
