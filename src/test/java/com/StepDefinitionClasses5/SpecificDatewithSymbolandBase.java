package com.StepDefinitionClasses5;

import org.junit.Assert;

import com.PojoSpecific.RatesSpecificwithSymbolandBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
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
	@Then("Verify that the response body with symbol and base has base as {string}")
	public void validateBase(String base1) {
		//Assert whether Base is same
	    Assert.assertTrue(response.getBody().asString().contains(base1));
	}
	@And("Verify that it contains rates of GBP")
	public void validateRates() {
		RatesSpecificwithSymbolandBase ratesofCountries = response.as(RatesSpecificwithSymbolandBase.class,ObjectMapperType.GSON);
		//Asserting if response has rates of GBP
		Assert.assertTrue(ratesofCountries.getRates().getGBP()>0);
		
	}
	
}
