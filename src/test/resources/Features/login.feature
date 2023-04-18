#Author				: Adriana Anggita Daeli
#Date					: 10/04/23
#Description	: Login feature scenarios

@SmokeScenario
Feature: feature to test login funcionality
	
  #Scenario: check login is succesful with valid credentials
    #Given browser is open
    #And user is on login page
    #When user enters "anggitadaeli@gmail.com" and "654321"
    #And clicks on login button
    #Then user is navigated to the home page
    
	@SmokeTest
  Scenario Outline: check login with kinds of valid and invalid
  	Given browser is open
    And user is on login page
  	When user enters <email> and <password>
  	And clicks on login button
  	Then user is navigated to the home page
  	
  	Examples:
  		| email							 					| | password	   	|
  		| anggitadaeli@gmail.com		 	| | 654321	 		 	| #kasir valid / tc1
  		| cholid@gmail.com 	 					| | 123456	 			| #admin valid / tc1
    	| ngasal@gmail.com 	 					| | tes123!! 			| #tc2 
    	| cholid@gmail.com 	 					| | ngasal	 			| #tc3 
    	| 									 					| | 				 			| #tc4 
    	| cholid@gmail.com 	 					| | 				 			| #tc5
    	| 									 					| | 123456	 			| #tc6