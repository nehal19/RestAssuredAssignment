package com.StepDefinitionClasses5;

import org.junit.Assert;

import com.PojoSpecific.RatesSpecificwithSymbol;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class SpecificDatewithSymbol {
	
private Response response;
	
	@Given("^Rates API for Specific Date Foreign Exchange rates with symbol$")
	public void buildAPI() {
		RestAssured.baseURI = "https://api.ratesapi.io";

	}

	@When("^The API with symbol is available$")
	public void invokeApI() {
		response =  RestAssured.get("/2010-01-12?symbols=USD,GBP");
   
	}
	@Then("Verify that  the response body with symbol has base as {string}")
	public void validateBase(String base) {
	    Assert.assertTrue(response.getBody().asString().contains(base));
	}
	@And("Verify that it contains rates of USD and GBP")
	public void validateRates() {
		RatesSpecificwithSymbol ratesofCountries = response.as(RatesSpecificwithSymbol.class,ObjectMapperType.GSON);
		Assert.assertTrue(ratesofCountries.getRates().getGBP()>0);
		Assert.assertTrue(ratesofCountries.getRates().getUSD()>0);
	}


}
