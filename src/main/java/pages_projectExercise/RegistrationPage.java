package pages_projectExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void waitForHomePageToBeVisible() {
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//img[@src='/static/images/home/logo.png']")));
    }
    public void waitForNewUserSignupToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//h2[contains(text(), 'New User Signup')]")));
    }
    public WebElement getNameInput() {
        return driver.findElement(By.name("name"));
    }
    public WebElement getEmailInput() {
        return driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
    }
    public WebElement getSignupButto() {
        return driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
    }
    public void waitForTitleTextToBePresent() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("text-center")));
    }
    public WebElement getMrTitleInput() {
        return driver.findElement(By.id("id_gender1"));
    }
    public WebElement getMrsTitleInput() {
        return driver.findElement(By.id("id_gender2"));
    }
    public WebElement getPasswordInput() {
        return driver.findElement(By.id("password"));
    }



}
