package com.RunnerClasses;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features="./src/test/resources/CurrencyExchangeFeatures/Criteria5.feature",
glue="com.StepDefinitionClasses5"
		)
public class RunCucumberTest5 {

}
