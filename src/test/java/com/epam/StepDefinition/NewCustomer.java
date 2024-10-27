package com.epam.StepDefinition;

import com.epam.Conifguration.BaseClass;
import com.epam.PageObjects.NewCustomerPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static com.epam.Conifguration.CommonFunctions.visitPage;


public class NewCustomer extends BaseClass {
    WebDriver driver;
    NewCustomerPage customerPage;
    String newCustomerURL="https://www.demo.guru99.com/V4/manager/addcustomerpage.php";

    @Before
    public void setUp() throws Exception {
        init("chrome");
        driver = getDriver();
        customerPage = new NewCustomerPage(driver);
        setUp(baseURL);
        Thread.sleep(2000);
    }

    @And("I click on the New Customer link")
    public void iClickOnTheNewCustomerLink() {
//        driver.get(customerPage.addCustomer);
        visitPage(driver, newCustomerURL);
    }

    @Then("I fill out the registration form with the following details")
    public void iFillOutTheRegistrationFormWithTheFollowingDetails(DataTable userDetails) {
        Map<String, String> data = userDetails.asMap(String.class, String.class);
        customerPage.typeNameField(data.get("name"));
        customerPage.selectGender(data.get("gender"));
        customerPage.typeDobField(data.get("dob"));
        customerPage.typeAddressField(data.get("address"));
        customerPage.typeCityField(data.get("city"));
        customerPage.typeStateField(data.get("state"));
        customerPage.typePinCodeField(data.get("pin"));
        customerPage.typeMobileField(data.get("mobile"));
        customerPage.typeMailField(data.get("email"));
        customerPage.typePasswordField(data.get("password"));
    }

    @And("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        customerPage.clickSubmit();
    }

    @Then("I should see a confirmation message {string}")
    public void iShouldSeeAConfirmationMessage(String message) {
        customerPage.verifyConfirmationMessage(message);
    }

//    @After
//    public void cleanUp() {
//        driver.quit();
//    }
}
