package com.epam.StepDefinition;

import com.epam.Conifguration.BaseClass;
import com.epam.PageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.epam.Conifguration.CommonFunctions.acceptPopupWindow;


public class Login extends BaseClass {
    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp() throws Exception {
        init("chrome");
        driver = getDriver();
        loginPage = new LoginPage(driver);

    }

    @Given("I am on the Guru99 Bank login page")
    public void iAmOnTheGuruBankLoginPage() throws InterruptedException {
//        setUp(baseURL);
//        Thread.sleep(2000);
    }

    @When("I enter a valid username as {string} and password as {string}")
    public void iEnterAValidUsernameAsAndPasswordAs(String userName, String password) {
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
    }

    @When("I enter an invalid username {string} and password {string}")
    public void iEnterAnInvalidUsernameAndPassword(String userName, String password) {
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the home page with title {string}")
    public void iShouldBeRedirectedToTheHomePageWithTitle(String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }


    @Then("I should see an alert with the message {string}")
    public void iShouldSeeAnAlertWithTheMessage(String message) {
        Assert.assertEquals(acceptPopupWindow(driver), message);
    }

    @After
    public void tearDown()  {
        cleanUp();
    }
}
