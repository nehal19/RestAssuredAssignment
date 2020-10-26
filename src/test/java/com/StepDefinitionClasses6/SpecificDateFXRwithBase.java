package com.StepDefinitionClasses6;

import java.time.LocalDate;
import java.time.ZoneId;

import org.junit.Assert;

import com.PojoLatest.RateswithBase;

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
	   response = RestAssured.get("/2022-10-10?base=USD");
	}
	@Then("Verify that  the response body with base has base as {string} and present date")
	public void validateBase(String base) {
		//Asserting if base is present
	    Assert.assertTrue(response.getBody().asString().contains(base));
	    
		RateswithBase ratesofCountries = response.as(RateswithBase.class,ObjectMapperType.GSON);
		String responsedate = ratesofCountries.getDate();
		ZoneId zoneEUR = ZoneId.of("Europe/Paris");
		String today = LocalDate.now(zoneEUR).toString();
		//Asserting Date
		Assert.assertEquals(responsedate,today);
		//Asserting Response Code
		Assert.assertEquals(200, response.getStatusCode());
	}


}
