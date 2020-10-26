package com.RunnerClasses;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
features="./src/test/resources/CurrencyExchangeFeatures/Criteria6.feature",
glue="com.StepDefinitionClasses6",
plugin = { "pretty", "html:target/cucumberTest6-reports" },
monochrome = true
		)
public class RunCucumberTest6 {

}
