Feature: Test the success status of the Latest Foreign Exchange rates

	Scenario: Assert the success status of Latest Foriegn Exchange rates response
	Given Rates API for Latest Foreign Exchange rates
	When The API is available
	Then Verify that the status code of the response is success
	
	Scenario: Assert the success status of the response for Latest Foriegn Exchange with Symbol
	Given Rates API for Latest Foreign Exchange rates with symbol
	When The API with symbol is available
	Then Verify that the status code of the response is 200
	
	Scenario: Assert the success status of the response for Latest Foriegn Exchange with Base
	Given Rates API for Latest Foreign Exchange rates with base
	When The API with base is available
	Then Verify that the status line of the response is "HTTP/1.1 200 OK"
	
	Scenario: Assert the success status of the response for Latest Foriegn Exchange with Symbol and Base
	Given Rates API for Latest Foreign Exchange rates with symbol and base
	When The API with symbol and base is available
	Then  Verify that the status code of response is 200
	And Verify that the version of HTTP is 1.1
	
	
	
	
	
