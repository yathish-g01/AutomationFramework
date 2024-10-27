package com.epam.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {
    private final Logger logger = LogManager.getLogger(NewAccountPage.class.getName());
    public WebDriver driver;

    public NewAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(name = "cusid")
    public WebElement customerID;

    @FindBy(name = "selaccount")
    public WebElement accountType;

    @FindBy(name = "inideposit")
    public WebElement depositField;

    @FindBy(name = "button2")
    public WebElement submitButton;

    @FindBy(css = ".heading3")
    public WebElement accountSuccessMessage;

    @FindBy(xpath = ".//*[@id='account']/tbody/tr[10]/td[2]")
    public WebElement currentAmount;


    public void typeCustomerID(String value) {
        customerID.clear();
        logger.info("CustomerId Field: Enter " + value);
        customerID.sendKeys(value);
    }

    public void typeInitialDeposit(String value) {
        depositField.clear();
        logger.info("Initial Deposit Field: Enter " + value);
        depositField.sendKeys(value);
    }

    public void clickSubmit() {
        if (submitButton.isEnabled()) {
            logger.info("Click submit.");
            submitButton.click();
        } else {
            logger.error("Not click submit.");
        }
    }

    public void selectAccountType(String value) {
        Select oSelect = new Select(accountType);
        oSelect.selectByValue(value);
    }

    public String getMsgAccSuccess() {
        logger.info("Get an messesage: " + accountSuccessMessage.getText());
        return accountSuccessMessage.getText();
    }

    public String getCurrentAmount() {
        logger.info("The current amount is " + currentAmount.getText());
        return currentAmount.getText();
    }
}

