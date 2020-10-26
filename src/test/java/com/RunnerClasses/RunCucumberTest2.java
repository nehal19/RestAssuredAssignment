package com.RunnerClasses;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
features="./src/test/resources/CurrencyExchangeFeatures/Criteria2.feature",
glue="com.StepDefinitionClasses2",
plugin = { "pretty", "html:target/cucumberTest2-reports" },
monochrome = true
		)
public class RunCucumberTest2 {

}
