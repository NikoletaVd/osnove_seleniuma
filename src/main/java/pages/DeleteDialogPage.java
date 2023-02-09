package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteDialogPage extends BasePage {


    public DeleteDialogPage(WebDriverWait wait, WebDriver driver) {
        super(wait, driver);
    }

    public void waitForDialogToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("delete")));
    }
    public void waitForDialogToBeInvisible() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("delete")));
    }


}
