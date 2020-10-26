package com.StepDefinitionClasses4;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SpecificDatewithSymbolandBase {
private Response response;
	
	@Given("Rates API for Specific Date Foreign Exchange rates with symbol and base")
	public void buildAPI() {
		RestAssured.baseURI = "https://api.ratesapi.io";
	}

	@When("The API with symbol and base is available")
	public void invokeAPI() {
	    response = RestAssured.get("/2010-01-12?base=USD&symbols=GBP");
	}

	@Then("Verify that the status code of response is {int}")
	public void validateStatusCode(Integer int1) {
	    Assert.assertEquals(int1.intValue(), response.getStatusCode());
	}

	@And("Verify that the version of HTTP is {double}")
	public void validateStatusLine(Double double1) {
	    Assert.assertTrue(response.getStatusLine().contains(double1.toString()));
	    System.out.println("Symbol and Base open");
	    System.out.println(response.prettyPrint());
	    System.out.println("Symbol and Base close");
	}
	
}
