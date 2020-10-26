package com.StepDefinitionClasses5;

import org.junit.Assert;

import com.PojoSpecific.RatesSpecificwithBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
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
	@Then("Verify that  the response body with base has base as {string}")
	public void validateBase(String base) {
	    Assert.assertTrue(response.getBody().asString().contains(base));
	}
	@And("Verify that it contains rates of EUR and NZD")
	public void validateRates() {
		RatesSpecificwithBase ratesofCountries = response.as(RatesSpecificwithBase.class,ObjectMapperType.GSON);
		Assert.assertTrue(ratesofCountries.getRates().getEUR()>0);
		Assert.assertTrue(ratesofCountries.getRates().getNZD()>0);
	}


}
