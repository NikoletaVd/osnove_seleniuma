package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TablePage extends BasePage{


    public TablePage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }

    public WebElement getEditButtonByRow (int row) {
        return driver.findElement(By.xpath("//tbody/tr["+row+"]/td/*[contains(@class, 'update')]"));

    }
    public WebElement getDeleteButtonByRow (int row) {
        return driver.findElement(By.xpath("//tbody/tr["+row+"]/td/*[contains(@class, 'delete')]"));

    }
    public WebElement getTbodyColumn(int row, int column) {
        return driver.findElement(By.xpath("//tbody/tr["+row+"]/td["+column+"]"));
    }
    public void waitForRowToBeDeleted (int row) {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr["+row+"]/td"), 0));
    }
}
