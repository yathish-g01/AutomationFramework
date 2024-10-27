package com.epam.TestCases;

import com.epam.Conifguration.BaseClass;
import com.epam.PageObjects.NewCustomerPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.Conifguration.CommonFunctions.visitPage;

public class NewCustomerTest extends BaseClass {
    private static Logger logger = LogManager.getLogger(LoginTest.class.getName());
    private String newCustomerURL = "http://www.demo.guru99.com/V4/manager/addcustomerpage.php";

    @Test(dataProvider = "newCustomerData")
    public void newCustomer(String name, String gender, String dob, String address,
                            String city, String state, String pinCode,
                            String mobile, String mail, String password) throws InterruptedException {
        NewCustomerPage newCustomerPage = new NewCustomerPage(driver);
        visitPage(driver, newCustomerURL);
        newCustomerPage.typeNameField(name);
        logger.info("Customer Name is set as " + name);
        newCustomerPage.selectGender(gender);
        logger.info("Customer Gender is set as " + gender);
        newCustomerPage.typeDobField(dob);
        logger.info("Customer DOB is set as " + dob);
        newCustomerPage.typeAddressField(address);
        logger.info("Customer Address is set as " + address);
        newCustomerPage.typeCityField(city);
        logger.info("Customer City is set as " + city);
        newCustomerPage.typeStateField(state);
        logger.info("Customer State is set as " + state);
        newCustomerPage.typePinCodeField(pinCode);
        logger.info("Customer PinCode is set as " + pinCode);
        newCustomerPage.typeMobileField(mobile);
        logger.info("Customer Mobile is set as " + mobile);
        newCustomerPage.typeMailField(mail);
        logger.info("Customer Mail is set as " + mail);
        newCustomerPage.typePasswordField(password);
        logger.info("Customer Password is set as " + password);
        newCustomerPage.clickSubmit();
        logger.info("Clicked on the submit button");
        Assert.assertEquals(newCustomerPage.registerCompletionText.getText(), "Customer Registered Successfully!!!");


    }


}
