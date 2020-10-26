package com.StepDefinitionClasses2;

import org.junit.Assert;

import com.PojoLatest.RateswithBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
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
	@Then("Verify that  the response body with base has base as {string}")
	public void validateBase(String base) {
		//Assert whether Base is same
	    Assert.assertTrue(response.getBody().asString().contains(base));
	}
	@And("Verify that it contains rates of EUR and NZD")
	public void validateRates() {
		RateswithBase ratesofCountries = response.as(RateswithBase.class,ObjectMapperType.GSON);
		//Asserting if response has rates of Europe
		Assert.assertTrue(ratesofCountries.getRates().getEUR()>0);
		//Asserting if response has rates of New Zealand
		Assert.assertTrue(ratesofCountries.getRates().getNZD()>0);
	}


}
