package com.StepDefinitionClasses6;

import java.time.LocalDate;
import java.time.ZoneId;

import org.junit.Assert;

import com.PojoLatest.RatesLFXR;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class SpecificDateExchangeRates {
private Response response;
	
	@Given("^Rates API for Specific Date Foreign Exchange rates$")
	public void buildAPI() throws Throwable{
		
		RestAssured.baseURI = "https://api.ratesapi.io";
		
	}

	@When("The API is available")
	public void invokeAPI() throws Throwable{
		//Sending Future Date
	    response = RestAssured.get("/api/2024-10-10");
		
	}

	@Then("Verify that the status code of the response is success and date is present date")
	public void validate() throws Throwable {
	
		
		RatesLFXR ratesofCountries = response.as(RatesLFXR.class,ObjectMapperType.GSON);
		String responsedate = ratesofCountries.getDate().toString();
		
		ZoneId zoneEUR = ZoneId.of("Europe/Paris");
		String today = LocalDate.now(zoneEUR).toString();
		//Asserting Date
		Assert.assertEquals(responsedate,today);
		//Asserting Response Code
		Assert.assertEquals(200, response.getStatusCode());
		    
	}


	
}
