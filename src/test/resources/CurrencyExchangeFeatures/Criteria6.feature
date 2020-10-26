Feature: Test the status for the Future Date Foreign Exchange rates

	Scenario: Assert the status for Future Date Foriegn Exchange rates response
	Given Rates API for Specific Date Foreign Exchange rates
	When The API is available
	Then Verify that the status code of the response is success and date is present date
	
	Scenario: Assert the response for Future Date Foriegn Exchange with Symbol
	Given Rates API for Specific Date Foreign Exchange rates with symbol
	When The API with symbol is available
	Then Verify that  the response body with symbol has base as "EUR" and present date
	
	
	Scenario: Assert the response for Future Date Foriegn Exchange with Base
	Given Rates API for Specific Date Foreign Exchange rates with base
	When The API with base is available
	Then Verify that  the response body with base has base as "USD" and present date
	
	Scenario: Assert the response for Future Date Foriegn Exchange with Symbol and Base
	Given Rates API for Specific Date Foreign Exchange rates with symbol and base
	When The API with symbol and base is available
	Then Verify that the response body with symbol and base has base as "USD"
	And Verify that it contains rates of GBP and present date 
	
