#Author				: Adriana Anggita Daeli
#Date					: 10/04/23
#Description	: Logout feature scenarios

@SmokeScenario
Feature: feature to test logout funcinality
	
	@SmokeTestLogout
  Scenario Outline: check logout bleven pos
  	Given browser is open
    And user login with <email> and <password> successfully
  	When clicks on logout button
  	Then user is navigated to the login page
  	Then user try to go to dashboard witout login
  	
   	Examples:
  		| email							 					| | password	   	|
  		| anggitadaeli@gmail.com		 	| | 654321	 		 	| #kasir valid / tc0.1.1
  		| cholid@gmail.com 	 					| | 123456	 			| #admin valid / tc0.1.1
  	
  	
  	