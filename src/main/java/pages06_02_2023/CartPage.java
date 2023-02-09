package pages06_02_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{

    public CartPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }
    public WebElement getDeleteButtonByIndex (int index) {
        return driver.findElement(By.xpath("//table/tbody/tr["+index+"]/td/a"));
    }
    public WebElement getCouponInput() {
        return driver.findElement(By.name("coupon_code"));
    }
    public WebElement getApplyCouponButton() {
        return driver.findElement(By.name("apply_coupon"));
    }
    public WebElement getUpdateCartButton() {
        return driver.findElement(By.name("update_cart"));
    }
    public void waitForNumberOfElementsToBe(int expectedNumber) {
        wait.until(ExpectedConditions.numberOfElementsToBe
                (By.xpath("//table/tbody/tr[@class='woocommerce-cart-form__cart-item cart_item']"), expectedNumber));
    }



}
