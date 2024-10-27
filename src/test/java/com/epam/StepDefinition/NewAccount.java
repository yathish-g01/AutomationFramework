package com.epam.StepDefinition;

import com.epam.Conifguration.BaseClass;
import com.epam.PageObjects.NewAccountPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static com.epam.Conifguration.CommonFunctions.visitPage;

public class NewAccount extends BaseClass {
    WebDriver driver;
    NewAccountPage newAccountPage;
    @Then("Go to the new account page")
    public void goToTheNewAccountPage() {
        newAccountPage = new NewAccountPage(driver);
        visitPage(driver,newAccountURL);
//        accountPage.();

    }

    @And("Fill the new account form with the following details")
    public void fillTheNewAccountFormWithTheFollowingDetails(DataTable table) {
        Map<String, String> data = table.asMap(String.class, String.class);
        newAccountPage.typeCustomerID(data.get("customerID"));
        logger.info("Customer ID is set as " + data.get("customerID"));
        newAccountPage.selectAccountType(data.get("accountType"));
        logger.info("Account Type is set as " + data.get("accountType"));
        newAccountPage.typeInitialDeposit(data.get("initialDeposit"));
        logger.info("Initial Deposit is set as " + data.get("initialDeposit"));
    }

    @And("I click on the account submit button")
    public void iClickOnTheAccountSubmitButton() {
        newAccountPage.clickSubmit();
    }

    @Then("I should see the account created message")
    public void iShouldSeeTheAccountCreatedMessage() {
        newAccountPage.getMsgAccSuccess();
    }
}
