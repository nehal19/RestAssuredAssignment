package com.StepDefinitionClasses3;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LatestForeignExchangeRates {
private Response response;
private final static Logger logr = Logger.getLogger("LatestForeignExchangeRates");

	
	@Given("^Rates API for Latest Foreign Exchange rates$")
	public void buildAPI() throws Throwable{
		
		RestAssured.baseURI = "https://api.ratesapi.io";
		
	}

	@When("^The API is available$")
	public void invokeAPI() throws Throwable{
	    //Giving Incomplete API
		response = RestAssured.get("/api/");
		
	}

	@Then("^Verify that the status code of the response is error$")
	public void validate() throws Throwable {
		//Assert response code
		Assert.assertEquals(400, response.getStatusCode());
		    String msg = response.prettyPrint().toString();
		  //Appending logs in a file
		    FileHandler fh = new FileHandler("failurelog.log");
		    logr.addHandler(fh);
		    //Logging
		    logr.info(msg);

		
	}
	@And("Verify that the version of HTTP is {double}")
	public void validateStatusLine(Double double1) {
	    Assert.assertTrue(response.getStatusLine().contains(double1.toString()));

	}
	
	
}
