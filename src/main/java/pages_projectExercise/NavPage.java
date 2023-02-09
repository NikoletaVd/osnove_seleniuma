package pages_projectExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getHomeLink() {
        return driver.findElement(By.linkText(" Home"));
    }
    public WebElement getProductsLink() {
        return driver.findElement(By.linkText(" Products"));
    }
    public WebElement getCartLink() {
        return driver.findElement(By.linkText(" Cart"));
    }
    public WebElement getSignupLoginLink() {
        return driver.findElement(By.linkText(" Signup / Login"));
    }
    public WebElement getTestCasesLink() {
        return driver.findElement(By.linkText(" Test Cases"));
    }
    public WebElement getApiTestingLink() {
        return driver.findElement(By.linkText(" API Testing"));
    }
    public WebElement getVideoTutorialsLink() {
        return driver.findElement(By.linkText(" Video Tutorials"));
    }
    public WebElement getContactUsLink() {
        return driver.findElement(By.linkText(" Contact us"));
    }
}
