package com.RunnerClasses;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
features="./src/test/resources/CurrencyExchangeFeatures/Criteria1.feature",
glue="com.StepDefinitionClasses1"
		)
public class RunCucumberTest1 {

}


