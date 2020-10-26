package com.StepDefinitionClasses2;

import org.junit.Assert;

import com.PojoLatest.RateswithSymbolandBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class LatestFXRwithSymbolandBase {
	
private Response response;
	
	@Given("Rates API for Latest Foreign Exchange rates with symbol and base")
	public void buildAPI() {
		RestAssured.baseURI = "https://api.ratesapi.io";
	}

	@When("The API with symbol and base is available")
	public void invokeAPI() {
	    response = RestAssured.get("/latest?base=USD&symbols=GBP");
	}
	@Then("Verify that the response body with symbol and base has base as {string}")
	public void validateBase(String base1) {
	    Assert.assertTrue(response.getBody().asString().contains(base1));
	}
	@And("Verify that it contains rates of GBP")
	public void validateRates() {
		RateswithSymbolandBase ratesofCountries = response.as(RateswithSymbolandBase.class,ObjectMapperType.GSON);
		Assert.assertTrue(ratesofCountries.getRates().getGBP()>0);
		
	}
	
	


}
