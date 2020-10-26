Feature: Test the Failure status of the Latest Foreign Exchange rates

	Scenario Outline: Assert the Failure status of Latest Foriegn Exchange rates response
	Given Rates API for Latest Foreign Exchange rates
	When The API is available
	Then Verify that the status code of the response is error
	And Verify that the version of HTTP is 1.1

	
	
	
	
