package com.StepDefinitionClasses4;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SpecificDateExchangeRates {
	
	private Response response;
	
	@Given("^Rates API for Specific Date Foreign Exchange rates$")
	public void buildAPI() throws Throwable{
		
		RestAssured.baseURI = "https://api.ratesapi.io";
		
	}

	@When("^The API is available$")
	public void invokeAPI() throws Throwable{
	   
		response = RestAssured.get("/api/2010-01-12");
		
	}

	@Then("^Verify that the status code of the response is success$")
	public void validate() throws Throwable {
		//Getting Status Line
	    System.out.println(response.getStatusLine());
	    //Asserting Status Code
		Assert.assertEquals(200, response.getStatusCode());
	    
	}

	
}
