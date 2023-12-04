package org.example.StepDefinition;

import Pages.P01_LoginPage;
import Pages.P02_DashboardPage;
import Pages.P03_AdminPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D01_NumberOfRecords {
    public static WebDriver driver;
    public static int recordNumber, currentRecordsNumber;


    @Given("user navigate to {string}")
    public void userNavigateTo(String url) {
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @Then("user login with {string} and {string}")
    public void enterValidData(String userName, String password) {
        new P01_LoginPage(driver).enterValidInputs(userName, password);
    }

    @And("user click on login button")
    public void userClickOnLoginButton() {
        new P01_LoginPage(driver).clickOnLoginBtn();
    }

    @Then("user logged in successfully")
    public void userLoggedInSuccessfully() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Verify URl After Logging in");
        soft.assertTrue(new P02_DashboardPage(driver).getUserDropDown().isDisplayed(), "Verify user DropDown Menu is presented");
        soft.assertAll();
    }

    @When("user click on Admin tab")
    public void userClickOnAdminTab() {
        new P02_DashboardPage(driver).clickOnAdminBtn();
    }

    @Then("get the number of records")
    public void getTheNumberIfRecords() {
        recordNumber = new P03_AdminPage(driver).getNumberOfRecords();
        System.out.println("Number of Records found: " + recordNumber);
    }

    @Given("user click on Add Button")
    public void userClickOnAddButton() {
        new P03_AdminPage(driver).clickOnAddBtn();
    }

    @When("user fill the required data")
    public void userFillTheRequiredData() throws InterruptedException {
        new P03_AdminPage(driver).fillRequiredFields();
    }

    @And("user click on Save Button")
    public void userClickOnSaveButton() throws InterruptedException {
        new P03_AdminPage(driver).clickOnSaveBtn();
    }

    @Then("Verify number of records increased by {int}")
    public void verifyNumberOfRecordsIncreasedBy(int num) {
        currentRecordsNumber = new P03_AdminPage(driver).getNumberOfRecords();
        System.out.println("Number of Records found: " + currentRecordsNumber);
        Assert.assertEquals(currentRecordsNumber - recordNumber, num);
    }


    @Given("user search with the new username")
    public void userSearchWithTheNewUsername() throws InterruptedException {
        new P03_AdminPage(driver).searchWithUserName();
    }

    @When("user Delete the new user")
    public void userDeleteTheNewUser() {
        new P03_AdminPage(driver).deleteUnewserName();
    }

    @Then("Verify number of records Decreased by {int}")
    public void verifyNumberOfRecordsDecreasedBy(int num2) throws InterruptedException {
        new P02_DashboardPage(driver).clickOnAdminBtn();
        Thread.sleep(1500);
        currentRecordsNumber = new P03_AdminPage(driver).getNumberOfRecords();
        System.out.println("Number of Records found: " + currentRecordsNumber);
        Assert.assertEquals(currentRecordsNumber, recordNumber);
    }

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}



