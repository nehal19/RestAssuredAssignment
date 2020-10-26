package com.StepDefinitionClasses6;

import java.time.LocalDate;
import java.time.ZoneId;

import org.junit.Assert;

import com.PojoLatest.RateswithSymbolandBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class SpecificDateFXRwithSymbolandBase {
	
	private Response response;

	@Given("Rates API for Specific Date Foreign Exchange rates with symbol and base")
	public void buildAPI() {
		RestAssured.baseURI = "https://api.ratesapi.io";
	}

	@When("The API with symbol and base is available")
	public void invokeAPI() {
	    response = RestAssured.get("/2023-10-10?base=USD&symbols=GBP");
	}
	@Then("Verify that the response body with symbol and base has base as {string}")
	public void validateBase(String base1) {
		//Asserting Base
	    Assert.assertTrue(response.getBody().asString().contains(base1));
	}
	@And("Verify that it contains rates of GBP and present date")
	public void validateRates() {
		RateswithSymbolandBase ratesofCountries = response.as(RateswithSymbolandBase.class,ObjectMapperType.GSON);
		String responsedate = ratesofCountries.getDate();
		ZoneId zoneEUR = ZoneId.of("Europe/Paris");
		String today = LocalDate.now(zoneEUR).toString();
		//Asserting Date
		Assert.assertEquals(responsedate,today);
		//Asserting Response Code
		Assert.assertEquals(200, response.getStatusCode());
		
	}
	
	


}
