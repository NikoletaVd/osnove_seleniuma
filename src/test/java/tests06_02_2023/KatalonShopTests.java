package tests06_02_2023;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KatalonShopTests extends BaseTest{

    @Test (priority = 10)
    @Description ("Adding product with quantity to the cart")
    public void addProductToTheCart() {
        driver.get(baseUrl + "/product/flying-ninja/");
        productPage.getQuantity().clear();
        productPage.getQuantity().sendKeys("3");
        productPage.getAddToCartButton().click();
        Assert.assertTrue(productPage.getMessage().getText().contains("Flying Ninja"),
                "Message does not match.");
        navPage.getCartLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"));
        cartPage.waitForNumberOfElementsToBe(1);
    }
    @Test (priority = 20)
    @Description ("Removing product from cart")
    public void removingProductFromCart() {
        driver.get(baseUrl);
        navPage.getCartLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"));
        cartPage.waitForNumberOfElementsToBe(1);
        cartPage.getDeleteButtonByIndex(1).click();
        cartPage.waitForNumberOfElementsToBe(0);
    }

}
