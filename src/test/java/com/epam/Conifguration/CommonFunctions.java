package com.epam.Conifguration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CommonFunctions {
    private static Logger logger = LogManager.getLogger(CommonFunctions.class.getName());
    private static WebDriver driver;

    private CommonFunctions() {
    }

    public static WebDriver getBrowser(String browser) throws Exception {
        if (driver == null) {
            synchronized (CommonFunctions.class) {
                if (driver == null) {
                    if (browser.equalsIgnoreCase("firefox")) {
                        logger.info(browser + " is set as the browser to run the application.");
                        System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
                        driver = new FirefoxDriver();
                    } else if (browser.equalsIgnoreCase("chrome")) {
                        logger.info(browser + " is set as the browser to run the application.");
                        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
                        driver = new ChromeDriver();
                    }else {
                        logger.error("Browser is not correct.");
                        throw new Exception("Browser is not correct");
                    }
                }
            }
        }
        return driver;
    }

    public static void visitPage(WebDriver driver, String url) {
        driver.manage().window().maximize();
        driver.get(url);
        logger.info("Navigated to the URL: " + url);
    }

    public static String acceptPopupWindow(WebDriver driver) {
        String actualBox = null;
        try {
            Alert alert = driver.switchTo().alert();
            actualBox = alert.getText();
            logger.info("Alert detected: {}" + alert.getText());
            alert.accept();

        } catch (NoAlertPresentException ex) {
            logger.warn("No Alert Present.");
        }
        return actualBox;
    }

    public static void dismissPopupWindow(WebDriver driver) {
        try {
            logger.info("Find the alert pop up and click dismiss");
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException ex) {
            logger.error("No Alert Present.");
        }
    }

    public static String takeScreenShot(WebDriver driver) throws IOException {
        logger.info("Screenshot taken.");
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String dest = "./src/test/java/reports/images/screenshot_" + timeStamp() + ".png";
        File destination = new File(dest);
        FileUtils.copyFile(src, destination);
        return dest;
    }

    public static String timeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

}
