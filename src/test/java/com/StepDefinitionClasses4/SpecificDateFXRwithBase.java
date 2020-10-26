package com.StepDefinitionClasses4;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SpecificDateFXRwithBase {
	
private Response response;
	
	@Given("Rates API for Specific Date Foreign Exchange rates with base")
	public void buildAPI() {
		RestAssured.baseURI = "https://api.ratesapi.io";
	}

	@When("The API with base is available")
	public void invokeAPI() {
	   response = RestAssured.get("/2010-01-12?base=USD");
	}

	@Then("Verify that the status line of the response is {string}")
	public void validate(String string) {
		System.out.println(response.getStatusLine());
	    Assert.assertEquals(string, response.getStatusLine());
	    System.out.println("Symbol open");
	    System.out.println(response.prettyPrint());
	    System.out.println("Symbol Close");
	}
}
