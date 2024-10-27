package com.epam.TestCases;

import com.epam.Conifguration.BaseClass;
import com.epam.Conifguration.CommonFunctions;
import com.epam.PageObjects.LoginPage;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseClass {
    private static Logger logger = LoggerFactory.getLogger(LoginTest.class.getName());

    @Test(dataProvider = "loginData")
    public void logIn(String userName, String password,String expectedTitle,boolean result) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Actions action = new Actions(driver);
        loginPage.setUserName(userName);
        logger.info("Username is set as " + userName);
        loginPage.setPassword(password);
        logger.info("Password is set as " + password);
        loginPage.clickLogin();
        logger.info("Clicked on the login button");
        if(result){
            Assert.assertEquals(driver.getTitle(),expectedTitle);
            logger.info("Login is successful");
        }
        else {
            Assert.assertEquals(CommonFunctions.acceptPopupWindow(driver),"User or Password is not valid");
            logger.info("Login is unsuccessful");
        }
        Thread.sleep(4000);
        driver.navigate().back();
        }
    }



