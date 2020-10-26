package com.StepDefinitionClasses2;

import org.junit.Assert;

import com.PojoLatest.RateswithSymbol;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class LatestFXRwithSymbol {
	
private Response response;
	
	@Given("^Rates API for Latest Foreign Exchange rates with symbol$")
	public void buildAPI() {
		RestAssured.baseURI = "https://api.ratesapi.io";

	}

	@When("^The API with symbol is available$")
	public void invokeApI() {
		
		response =  RestAssured.get("/latest?symbols=USD,GBP");
   
	}
	@Then("Verify that  the response body with symbol has base as {string}")
	public void validateBase(String base) {
		//Assert whether Base is same
	    Assert.assertTrue(response.getBody().asString().contains(base));
	}
	@And("Verify that it contains rates of USD and GBP")
	public void validateRates() {
		RateswithSymbol ratesofCountries = response.as(RateswithSymbol.class,ObjectMapperType.GSON);
		//Asserting if response has rates of GBP
		Assert.assertTrue(ratesofCountries.getRates().getGBP()>0);
		//Asserting if response has rates of USD
		Assert.assertTrue(ratesofCountries.getRates().getUSD()>0);
	}

}
