package com.StepDefinitionClasses1;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class LatestFXRwithBase {
	
	private Response response;
	
	@Given("Rates API for Latest Foreign Exchange rates with base")
	public void buildAPI() {
		RestAssured.baseURI = "https://api.ratesapi.io";
	}

	@When("The API with base is available")
	public void invokeAPI() {
	   response = RestAssured.get("/latest?base=USD");
	}

	@Then("Verify that the status line of the response is {string}")
	public void validate(String string) {
		//Getting Status Line
		System.out.println(response.getStatusLine());
		//Asserting Status Line
	    Assert.assertEquals(string, response.getStatusLine());
	}
}
