package org.example.Runners.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_LoginPage {
    public WebDriver driver;

    //////////Constructor
    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    ////////Locators
    public WebElement getUserNameInput() {
        return driver.findElement(By.xpath("//input[@name='username']"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.xpath("//input[@name='password']"));
    }

    public WebElement getLoginBtn() {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }


    public void enterValidInputs(String userName, String password) {
        getUserNameInput().clear();
        getUserNameInput().sendKeys(userName);
        getPasswordInput().clear();
        getPasswordInput().sendKeys(password);
    }

    public void clickOnLoginBtn() {
        getLoginBtn().click();
    }


}
