package com.epam.Executions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
        "src/test/resources/Features/Login.feature",
        "src/test/resources/Features/NewCustomer.feature",
        "src/test/resources/Features/NewAccount.feature"
},
        glue = {"com.epam.StepDefinition"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true)
public class FeatureRunner {
}