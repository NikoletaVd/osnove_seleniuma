package p06_02_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DeleteDialogPage;
import pages.EditDialogPage;
import pages.TablePage;

import java.time.Duration;

public class Uvod extends BaseTest{

    @Test
    public void editRow() {
        driver.get(baseUrl + "/iframe/K5yrx");
        tablePage.getEditButtonByRow(1).click();
        editDialogPage.waitForDialogToBeVisible();
        editDialogPage.getFirstNameInput().clear();
        editDialogPage.getFirstNameInput().sendKeys("Harry");
        editDialogPage.getLastNameInput().clear();
        editDialogPage.getLastNameInput().sendKeys("Potter");
        editDialogPage.getFMiddleNameInput().clear();
        editDialogPage.getFMiddleNameInput().sendKeys("James");
        Assert.assertEquals(tablePage.getTbodyColumn(1, 2).getText(), "Harry",
                "First name does not match");

    }
    @Test
    public void deleteRow() {
        driver.get(baseUrl + "/iframe/K5yrx");
        tablePage.getDeleteButtonByRow(1).click();
        deleteDialogPage.waitForDialogToBeVisible();
        tablePage.waitForRowToBeDeleted(1);

    }


}
