package pages06_02_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage{

    public NavPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }
    public WebElement getCartLink() {
        return driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/cart/']"));
    }
    public WebElement getCheckoutLink() {
        return driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/checkout/']"));
    }
    public WebElement getMyAccountLink() {
        return driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/my-account/']"));
    }
    public WebElement getSamplePageLink() {
        return driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/sample-page/']"));
    }
    public WebElement getShopLink() {
        return driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/']"));
    }

}
