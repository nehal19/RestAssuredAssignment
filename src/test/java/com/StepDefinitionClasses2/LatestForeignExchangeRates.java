package com.StepDefinitionClasses2;

import org.junit.Assert;

import com.PojoLatest.RatesLFXR;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class LatestForeignExchangeRates {
	
private Response response;
	
	@Given("Rates API for Latest Foreign Exchange rates")
	public void buildAPI() throws Throwable {
		
		RestAssured.baseURI = "https://api.ratesapi.io";
		
	}

	@When("^The API is available$")
	public void invokeAPI() throws Throwable{
	    
		response = RestAssured.get("/api/latest");
	}
	
	@Then("Verify that  the response body has base as {string}")
	public void validateBase(String base) {
	    Assert.assertTrue(response.getBody().asString().contains(base));
	}
	
	@And("Verify that the rate of INR is greater than {int}")
	public void validateRates(Integer int1) {
	RatesLFXR ratesofCountries = response.as(RatesLFXR.class,ObjectMapperType.GSON);
	Assert.assertTrue(ratesofCountries.getRates().getINR()>int1);
	   
	   
	}

	
}
