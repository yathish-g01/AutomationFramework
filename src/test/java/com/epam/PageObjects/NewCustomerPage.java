package com.epam.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
    WebDriver driver;
    private final Logger logger = LogManager.getLogger(NewCustomerPage.class.getName());
    public String addCustomer="https://www.demo.guru99.com/V4/manager/addcustomerpage.php";
    public NewCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "name")
    public WebElement customerName;

    @FindBy(id = "message")
    public WebElement nameErrText;

    @FindBy(xpath = "//input[@value='f']")
    public WebElement genderFemale;

    @FindBy(xpath = "//input[@value='m']")
    public WebElement genderMale;

    @FindBy(id = "dob")
    public WebElement dateOfBirth;

    @FindBy(id = "message24")
    public WebElement dateOfBirthErrText;

    @FindBy(xpath = "//textarea[@name='addr']")
    public WebElement addressField;

    @FindBy(id = "message3")
    public WebElement addressErrText;

    @FindBy(name = "city")
    public WebElement city;

    @FindBy(id = "message4")
    public WebElement cityErrText;

    @FindBy(name = "state")
    public WebElement state;

    @FindBy(id = "message5")
    public WebElement stateErrText;

    @FindBy(name = "pinno")
    public WebElement pinNo;

    @FindBy(id = "message6")
    public WebElement pinNoErrText;

    @FindBy(name = "telephoneno")
    public WebElement mobileNo;

    @FindBy(id = "message7")
    public WebElement mobileNoErrText;

    @FindBy(name = "emailid")
    public WebElement emailId;

    @FindBy(id = "message9")
    public WebElement emailIdErrText;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(id = "message18")
    public WebElement passwordErrText;

    @FindBy(name = "sub")
    public WebElement submitBtn;

    @FindBy(css = ".heading3")
    public WebElement registerCompletionText;

    public void typeNameField(String value) {
        customerName.clear();
        logger.info("Name Field: Enter " + value);
        customerName.sendKeys(value);
//        logger.info("Press TAB");
//        customerName.sendKeys(Keys.TAB);
    }

    public String getErrMsgName() {
        logger.info("Get an error messesage: " + nameErrText.getText());
        return nameErrText.getText();
    }

    public void selectGender(String value) {
        if (value.equalsIgnoreCase("male")) {
            genderMale.click();
        } else {
            genderFemale.click();
        }
    }

    public void typeDobField(String value) {
        // Using clear will throw an error instead of Key.Delete
        // https://stackoverflow.com/questions/28711969/webdriverexception-element-must-be-user-editable-in-order-to-clear-it
        //FLD_DOB.clear();
        dateOfBirth.sendKeys(Keys.DELETE);
        logger.info("Dob Field: Enter " + value);
        dateOfBirth.sendKeys(value);
    }

    public String getErrMsgDob() {
        logger.info("Get an error messesage: " + dateOfBirthErrText.getText());
        return dateOfBirthErrText.getText();
    }

    public void typeAddressField(String value) {
        addressField.clear();
        logger.info("Address Field: Enter " + value);
        addressField.sendKeys(value);
//        logger.info("Press TAB");
//        addressField.sendKeys(Keys.TAB);
    }

    public String getErrMsgAddress() {
        logger.info("Get an error messesage: " + addressErrText.getText());
        return addressErrText.getText();
    }

    public void typeCityField(String value) {
        city.clear();
        logger.info("City Field: Enter " + value);
        city.sendKeys(value);
        logger.info("Press TAB");
        city.sendKeys(Keys.TAB);
    }

    public String getErrMsgCity() {
        logger.info("Get an error messesage: " + cityErrText.getText());
        return cityErrText.getText();
    }

    public void typeStateField(String value) {
        state.clear();
        logger.info("State Field: Enter " + value);
        state.sendKeys(value);
        logger.info("Press TAB");
        state.sendKeys(Keys.TAB);
    }

    public String getErrMsgState() {
        logger.info("Get an error messesage: " + stateErrText.getText());
        return stateErrText.getText();
    }

    public void typePinCodeField(String value) {
        pinNo.clear();
        logger.info("Pin Field: Enter " + value);
        pinNo.sendKeys(value);
        logger.info("Press TAB");
        pinNo.sendKeys(Keys.TAB);
    }

    public String getErrMsgPin() {
        logger.info("Get an error messesage: " + pinNoErrText.getText());
        return pinNoErrText.getText();
    }

    public void typeMobileField(String value) {
        mobileNo.clear();
        logger.info("Mobile Field: Enter " + value);
        mobileNo.sendKeys(value);
        logger.info("Press TAB");
        mobileNo.sendKeys(Keys.TAB);
    }

    public String getErrMsgMobiNum() {
        logger.info("Get an error messesage: " + mobileNoErrText.getText());
        return mobileNoErrText.getText();
    }

    public void typeMailField(String value) {
        emailId.clear();
        logger.info("Mail Field: Enter " + value);
        emailId.sendKeys(value);
        logger.info("Press TAB");
        emailId.sendKeys(Keys.TAB);
    }

    public String getErrMsgMail() {
        logger.info("Get an error messesage: " + emailIdErrText.getText());
        return emailIdErrText.getText();
    }

    public void typePasswordField(String value) {
        password.clear();
        logger.info("Pass Field: Enter " + value);
        password.sendKeys(value);
    }

    public String getErrMsgPass() {
        logger.info("Get an error messesage: " + passwordErrText.getText());
        return password.getText();
    }

    public void clickSubmit() {
        if (submitBtn.isEnabled()) {
            logger.info("Click submit.");
            submitBtn.click();
        } else {
            logger.error("Not click submit.");
        }
    }

    public String getMsgRegister() {
        logger.info("Get an messesage: " + registerCompletionText.getText());
        return registerCompletionText.getText();
    }

    public void verifyConfirmationMessage(String message) {
        if (getMsgRegister().equals(message)) {
            logger.info("Confirmation message is correct.");
        } else {
            logger.error("Confirmation message is incorrect.");
        }
    }


}
