package com.RunnerClasses;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
features="./src/test/resources/CurrencyExchangeFeatures/Criteria4.feature",
glue="com.StepDefinitionClasses4"
		)
public class RunCucumberTest4 {

}
