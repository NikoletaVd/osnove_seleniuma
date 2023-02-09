package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriverWait wait;
    protected WebDriver driver;

    public BasePage (WebDriverWait wait, WebDriver driver) {
        this.wait = wait;
        this.driver = driver;
    }
}
