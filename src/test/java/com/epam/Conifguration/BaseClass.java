package com.epam.Conifguration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;


public class BaseClass {
    public String baseURL = "https://www.demo.guru99.com/V4/index.php";
        public String password = "japYmYb";
    public String newAccountURL = "http://www.demo.guru99.com/V4/manager/addAccount.php";
    public static WebDriver driver;
    public static Logger logger = LogManager.getLogger(BaseClass.class.getName());

    @Parameters("browserName")
    @BeforeTest
    public static void init(String browserName) throws Exception {
        logger.info("Selecting the browser to run the application");
        driver = CommonFunctions.getBrowser(browserName);
        logger.info("Browser is set as " + browserName);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @Parameters("url")
    @BeforeMethod
    public void setUp(String url) throws InterruptedException {
        CommonFunctions.visitPage(driver, url);
        Thread.sleep(2000);
        logger.info("URL is opened");
    }

    @DataProvider(name = "loginData")
    public static Object[][] testLoginData() {
        return new Object[][]{
                {"mngr578130", "japYmYb","Guru99 Bank Manager HomePage",true},
                {"mngr578130", "japYmY","User or Password is not valid",false},
                {"mngr57813", "japmYb","User or Password is not valid",false},
        };
    }

    @DataProvider(name = "newCustomerData")
    public static Object[][] getNewCustomerData(){
        return new Object[][]{
                { "john", "male", "01/01/1990", "Church Street","City","State","123456","1234567890","abcd12@me.com","password"},
                { "john", "male", "01/01/1990", "Church Street","City","State","123456","1234567890","abcd123@me.com","password"},
                { "john", "male", "01/01/1990", "Church Street","City","State","123456","1234567890","abcd121@me.com","password"},
        };
    }

    @DataProvider(name = "newAccountData")
    public static Object[][] getAccountData() {
        return new Object[][]{
                {"82531", "Savings", "1213" },
                {"82531", "Current", "1400" }
        };
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE) {
            CommonFunctions.takeScreenShot(driver);
        }
    }



    @AfterTest
    public void cleanUp()  {
        logger.info("Close browser.");
        driver.quit();
    }
}





