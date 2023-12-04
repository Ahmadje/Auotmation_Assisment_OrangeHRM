package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P02_DashboardPage {
    public WebDriver driver;

    ////////Constructor
    public P02_DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    ////////Locators
    public WebElement getUserDropDown() {
        return driver.findElement(By.cssSelector(".oxd-userdropdown-tab"));
    }

    public WebElement getAdminBtn() {
        return driver.findElement(By.xpath("//ul[@class=\"oxd-main-menu\"]/li [contains(.,'Admin')]"));
    }


    public void clickOnAdminBtn() {
        getAdminBtn().click();
    }



}
