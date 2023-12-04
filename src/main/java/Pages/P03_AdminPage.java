package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P03_AdminPage {
    public WebDriver driver;
    static String empolyeeName;

    ////////Constructor
    public P03_AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    ////////Locators
    private WebElement userRoleDropdown() {
        return driver.findElement(By.xpath("(//label[@class='oxd-label oxd-input-field-required'] [contains(.,'User Role') or contains(.,'Rol de Usuario')]//following::div)[1]"));
    }

    private WebElement userRoleSelect() {
        return driver.findElement(By.xpath("//div[@role='option'] [contains(.,'Admin') or contains(.,'Administrador')]"));
    }

    private WebElement statusDropdown() {
        return driver.findElement(By.xpath("(//label[@class='oxd-label oxd-input-field-required'] [contains(.,'Status') or contains(.,'Estatus')]//following::div)[1]"));
    }

    private WebElement statusSelect() {
        return driver.findElement(By.xpath("//div[@role='option'] [contains(.,'Enabled') or contains(.,'Habilitado')]"));
    }

    private WebElement employeeNameInput() {
        return driver.findElement(By.xpath("(//label[text()='Employee Name' or text()='Nombre del Empleado']//following::input)[1]"));
    }

    private WebElement employeeNameSelect() {
            return driver.findElement(By.xpath("(//div[@role='listbox'])[1]"));
    }

    private WebElement getEmployeeNameEle() {
        return driver.findElement(By.xpath("(//div[@class=\"oxd-table-cell oxd-padding-cell\"])[4]"));
    }

    private WebElement userNameInput() {
        return driver.findElement(By.xpath("(//label[text()='Username' or text()='Nombre de usuario']//following::input)[1]"));
    }

    private WebElement passwordInput() {
        return driver.findElement(By.xpath("(//label[text()='Password' or text()='Contraseña']//following::input)[1]"));
    }

    private WebElement confirmPasswordInput() {
        return driver.findElement(By.xpath("//label[text()='Confirm Password' or text()='Confirme contraseña']//following::input"));
    }

    private WebElement getSaveBtn() {
        return driver.findElement(By.xpath("//button[@type=\"submit\"] [contains(.,'Save') or contains(.,'Guardar')]"));
    }

    private WebElement getSearchBtn() {
        return driver.findElement(By.xpath("//button[@type=\"submit\"] [contains(.,'Search') or contains(.,'Buscar')]"));
    }

    private WebElement getDeleteBtn() {
        return driver.findElement(By.xpath("//i[@class=\"oxd-icon bi-trash\"]/parent::button"));
    }

    private WebElement confirmDeleteBtn() {
        return driver.findElement(By.xpath("//button[@type=\"button\"] [contains(.,' Yes, Delete ')]"));
    }

    private WebElement getAddBtn() {
        return driver.findElement(By.xpath("//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]/parent::button"));
    }

    private WebElement getNumberOfRecordsEle() {
        return driver.findElement(By.xpath("//span[@class=\"oxd-text oxd-text--span\"]"));
    }


    public void clickOnAddBtn() {
        getAddBtn().click();
    }

    public void fillRequiredFields() throws InterruptedException {
        userRoleDropdown().click();
        userRoleSelect().click();
        statusDropdown().click();
        statusSelect().click();
        employeeNameInput().sendKeys(empolyeeName);
        Thread.sleep(1500);
        employeeNameSelect().click();
//        int random = (int) (Math.random() * ((100 - 1) + 1));
        userNameInput().sendKeys("AhmadJoe");
        passwordInput().sendKeys("Test@1234");
        confirmPasswordInput().sendKeys("Test@1234");
    }

    public void clickOnSaveBtn() throws InterruptedException {
        getSaveBtn().click();
        Thread.sleep(1500);
    }

    public int getNumberOfRecords() {
        String Txt = getNumberOfRecordsEle().getText();
        String numberString = Txt.replaceAll("[^0-9]", "");
        int currentRecordsNumber = Integer.parseInt(numberString);
        empolyeeName = getEmployeeName();
        return currentRecordsNumber;
    }

    public String getEmployeeName() {
        return getEmployeeNameEle().getText();
    }

    public void searchWithUserName() {
        userNameInput().sendKeys("AhmadJoe");
        getSearchBtn().click();
    }

    public void deleteNewUserName() {
        getDeleteBtn().click();
        confirmDeleteBtn().click();
    }
}
