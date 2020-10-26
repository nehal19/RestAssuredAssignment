package com.StepDefinitionClasses6;

import java.time.LocalDate;
import java.time.ZoneId;

import org.junit.Assert;

import com.PojoLatest.RateswithSymbol;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class SpecificDateFXRwithSymbol {
	
private Response response;
	
	@Given("^Rates API for Specific Date Foreign Exchange rates with symbol$")
	public void buildAPI() {
		RestAssured.baseURI = "https://api.ratesapi.io";

	}

	@When("^The API with symbol is available$")
	public void invokeApI() {
		response =  RestAssured.get("/2021-10-10?symbols=USD,GBP");
   
	}
	@Then("Verify that  the response body with symbol has base as {string} and present date")
	public void validateBase(String base) {
		//Asserting if base is present
	    Assert.assertTrue(response.getBody().asString().contains(base));
		RateswithSymbol ratesofCountries = response.as(RateswithSymbol.class,ObjectMapperType.GSON);
		String responsedate = ratesofCountries.getDate();
		ZoneId zoneEUR = ZoneId.of("Europe/Paris");
		String today = LocalDate.now(zoneEUR).toString();
		//Asserting Date
		Assert.assertEquals(responsedate,today);
		//Asserting Response Code
		Assert.assertEquals(200, response.getStatusCode());
	}

}
