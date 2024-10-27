package com.epam.TestCases;

import com.epam.Conifguration.BaseClass;
import com.epam.PageObjects.NewAccountPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.Conifguration.CommonFunctions.visitPage;


public class NewAccountTest extends BaseClass {
    private static Logger logger = LogManager.getLogger(NewAccountTest.class.getName());
    private String newAccountURL = "http://www.demo.guru99.com/V4/manager/addAccount.php";

    @Test(dataProvider = "newAccountData")
    public void newAccount(String customerID, String accountType, String initialDeposit) throws InterruptedException {
        NewAccountPage newAccountPage = new NewAccountPage(driver);
        visitPage(driver,newAccountURL);
        newAccountPage.typeCustomerID(customerID);
        logger.info("Customer ID is set as " + customerID);
        newAccountPage.selectAccountType(accountType);
        logger.info("Account Type is set as " + accountType);
        newAccountPage.typeInitialDeposit(initialDeposit);
        logger.info("Initial Deposit is set as " + initialDeposit);
        newAccountPage.clickSubmit();
        logger.info("Clicked on the submit button");
        Assert.assertEquals(newAccountPage.getMsgAccSuccess(), "Account Generated Successfully!!!");
        logger.info("Account is created successfully");
        Thread.sleep(2000);
        driver.navigate().back();
    }

}
