Feature: Test the response of the Latest Foreign Exchange rates

	Scenario: Assert the response of Latest Foriegn Exchange rates response
	Given Rates API for Latest Foreign Exchange rates
	When The API is available
	Then Verify that  the response body has base as "EUR"
	And Verify that the rate of INR is greater than 0
	
	Scenario: Assert the response of the response for Latest Foriegn Exchange with Symbol
	Given Rates API for Latest Foreign Exchange rates with symbol
	When The API with symbol is available
	Then Verify that  the response body with symbol has base as "EUR"
	And Verify that it contains rates of USD and GBP
	
	Scenario: Assert the response of the response for Latest Foriegn Exchange with Base
	Given Rates API for Latest Foreign Exchange rates with base
	When The API with base is available
	Then Verify that  the response body with base has base as "USD"
	And Verify that it contains rates of EUR and NZD
	
	Scenario: Assert the response of the response for Latest Foriegn Exchange with Symbol and Base
	Given Rates API for Latest Foreign Exchange rates with symbol and base
	When The API with symbol and base is available
	Then Verify that the response body with symbol and base has base as "USD"
	And Verify that it contains rates of GBP 
	
	
	
	
	
