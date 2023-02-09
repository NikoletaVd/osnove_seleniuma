package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;

public class EditDialogPage extends BasePage{

    public EditDialogPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }

    public void waitForDialogToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit")));
    }
    public void waitForDialogToBeInvisible() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("edit")));
    }
    public WebElement getFirstNameInput() {
        return driver.findElement(By.id("fn"));
    }
    public WebElement getFMiddleNameInput() {
        return driver.findElement(By.id("mn"));
    }
    public WebElement getLastNameInput() {
        return driver.findElement(By.id("ln"));
    }
    public WebElement getUpdateButton() {
        return driver.findElement(By.id("up"));
    }

}
