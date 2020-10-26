package com.RunnerClasses;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
features="./src/test/resources/CurrencyExchangeFeatures/Criteria3.feature",
glue="com.StepDefinitionClasses3",
plugin = { "pretty", "html:target/cucumberTest3-reports" },
monochrome = true
		)
public class RunCucumberTest3 {

}
