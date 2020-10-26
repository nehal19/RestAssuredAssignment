package com.StepDefinitionClasses4;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SpecificDatewithSymbol {

	private Response response;
	
	@Given("Rates API for Specific Date Foreign Exchange rates with symbol")
	public void buildAPI() {
		RestAssured.baseURI = "https://api.ratesapi.io";

	}

	@When("^The API with symbol is available$")
	public void invokeApI() {
		response =  RestAssured.get("/2010-01-12?symbols=USD,GBP");
	    
	}

	@Then("Verify that the status code of the response is {int}")
	public void validate(Integer int1) {
	    Assert.assertEquals(int1.intValue(), response.getStatusCode());
	    System.out.println("Base open");
	    response.prettyPrint();
	    System.out.println("Base close");
	    
	}
}
