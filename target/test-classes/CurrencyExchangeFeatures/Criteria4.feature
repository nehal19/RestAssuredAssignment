Feature: Test the success status of the Specific Date Foreign Exchange rates

	Scenario: Assert the success status of Specific Date Foriegn Exchange rates response
	Given Rates API for Specific Date Foreign Exchange rates
	When The API is available
	Then Verify that the status code of the response is success
	
	Scenario: Assert the success status of the response for Specific Date Foriegn Exchange with Symbol
	Given Rates API for Specific Date Foreign Exchange rates with symbol
	When The API with symbol is available
	Then Verify that the status code of the response is 200
	
	Scenario: Assert the success status of the response for Specific Date Foriegn Exchange with Base
	Given Rates API for Specific Date Foreign Exchange rates with base
	When The API with base is available
	Then Verify that the status line of the response is "HTTP/1.1 200 OK"
	
	Scenario: Assert the success status of the response for Specific Date Foriegn Exchange with Symbol and Base
	Given Rates API for Specific Date Foreign Exchange rates with symbol and base
	When The API with symbol and base is available
	Then  Verify that the status code of response is 200
	And Verify that the version of HTTP is 1.1
	
	
	
	
	
