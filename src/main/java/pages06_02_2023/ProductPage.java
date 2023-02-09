package pages06_02_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductPage extends BasePage{
    public ProductPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }
    public WebElement getQuantity() {
        return driver.findElement(By.xpath("//input[@name='quantity']"));
//        return driver.findElement(By.className("quantity-up"));
    }
    public WebElement getAddToCartButton() {
        return driver.findElement(By.name("add-to-cart"));
    }
    public void waitForMessageToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("woocommerce-message")));
    }
    public WebElement getMessage() {
        return driver.findElement(By.className("woocommerce-message"));
    }
    public WebElement getTableRow() {
        return driver.findElement(By.xpath
                ("//table/tbody/tr[@class='woocommerce-cart-form__cart-item cart_item']"));
    }

}
