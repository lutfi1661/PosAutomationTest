#Author				: Adriana Anggita Daeli
#Date					: 10/04/23
#Description	: Dashboard feature scenarios

@SmokeScenario
Feature: feature to test dashboard funcionality
	
	@SmokeTest
  Scenario: check navigate on button employee card 
   	Given browse bleven pos website successfully for dashboard
    And user login to bleven pos successfully for dashboard
  	When clicks on employee card
  	Then user is navigated to the employee page
   