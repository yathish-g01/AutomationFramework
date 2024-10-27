package com.epam.DesktopApplication;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorAutomation {
    private static WindowsDriver<WindowsElement> driver = null;

    public static void main(String[] args) {s
        try {
            setup();
            testAddition();
            tearDown();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("deviceName", "WindowsPC");

        driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capabilities);
    }

    public static void testAddition() {
        // Clear any existing input
        driver.findElementByName("Clear").click();

        // Perform 1 + 2 = 3
        driver.findElementByName("One").click();
        driver.findElementByName("Plus").click();
        driver.findElementByName("Two").click();
        driver.findElementByName("Equals").click();

        // Get the result
        String result = driver.findElementByAccessibilityId("CalculatorResults").getText();
        System.out.println("Result: " + result);

        // Validate the result
        if (result.contains("3")) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}