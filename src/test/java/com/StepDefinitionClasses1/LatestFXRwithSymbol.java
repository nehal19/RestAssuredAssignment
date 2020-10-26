package com.StepDefinitionClasses1;


import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class LatestFXRwithSymbol {
	
	private Response response;
	
	@Given("^Rates API for Latest Foreign Exchange rates with symbol$")
	public void buildAPI() {
		RestAssured.baseURI = "https://api.ratesapi.io";

	}

	@When("^The API with symbol is available$")
	public void invokeApI() {
		response =  RestAssured.get("/latest?symbols=USD,GBP");
	    
	}

	@Then("Verify that the status code of the response is {int}")
	public void validate(Integer int1) {
		//Asserting Status Code
	    Assert.assertEquals(int1.intValue(), response.getStatusCode());
	   
	    
	}
}
