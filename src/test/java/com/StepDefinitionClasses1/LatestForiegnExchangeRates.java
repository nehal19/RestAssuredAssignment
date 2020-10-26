package com.StepDefinitionClasses1;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LatestForiegnExchangeRates {
	
	private Response response;
	
	@Given("^Rates API for Latest Foreign Exchange rates$")
	public void buildAPI() throws Throwable{
		
		RestAssured.baseURI = "https://api.ratesapi.io";
		
	}

	@When("^The API is available$")
	public void invokeAPI() throws Throwable{
	    
		response = RestAssured.get("/api/latest");
		
	}

	@Then("^Verify that the status code of the response is success$")
	public void validate() throws Throwable {
		//Getting Status Line
	    System.out.println(response.getStatusLine());
	    //Asserting status code
		Assert.assertEquals(200, response.getStatusCode());
		 
	}
	
	

}
