package com.StepDefinitionClasses5;

import org.junit.Assert;

import com.PojoSpecific.RatesSpecificFXR;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class SpecificDateExchangeRates {
	
private Response response;
	
	@Given("Rates API for Specific Date Foreign Exchange rates")
	public void buildAPI() throws Throwable {
		
		RestAssured.baseURI = "https://api.ratesapi.io";
		
	}

	@When("^The API is available$")
	public void invokeAPI() throws Throwable{
	    
		response = RestAssured.get("/api/2010-01-12");
	}
	
	@Then("Verify that  the response body has base as {string}")
	public void validateBase(String base) {
	    Assert.assertTrue(response.getBody().asString().contains(base));
	}
	
	@And("Verify that the rate of INR is greater than {int}")
	public void validateRates(Integer int1) {
	RatesSpecificFXR ratesofCountries = response.as(RatesSpecificFXR.class,ObjectMapperType.GSON);
	Assert.assertTrue(ratesofCountries.getRates().getINR()>int1);
	   
	   
	}


}
