@EditEmployee
Feature: Feature to check edit employee is successful
	
	#For TC 1	
	@EditEmployee1
	Scenario Outline: Check edit employee is succesful with valid credentials
		Given browser edit employee is opened
		And user edit employee is on home page
		And clicks on edit employee button
		And user clicks button edit employee
		And user is showed modal pop up edit employee
		When user enters "Lamda Update" and "lamda2@gmail"
		And user click button update
		Then user should see the edit employee success notification
    And modal pop up edit should be closed automatically
    
  #For TC 2-5
	@EditEmployee2
	Scenario Outline: Check edit employee is un-successful with invalid credentials. <condition>	
		Given browser edit employee is opened
		And user edit employee is on home page
		And clicks on edit employee button
		And user clicks button edit employee
		And user is showed modal pop up edit employee
		When user enters "<name>" and "<email>"
		And user click button update
		Then user should be able to see "<unsuccessReason>" edit notification
		
	Examples:
	  	| name   			 | email            | condition													  									   | unsuccessReason							|
		  | ,./&)(^  		 | lamda2@gmail.com | Its is update cashier name with invalid name      			 | name field is wrong         	|		
		  | Lamda	Update | lamda2gmail.com	| Its is update cashier name valid, but email is invalid	 | email field is wrong					|
		  |         	   | lamda2@gmail.com	| Its is update email valid, but cashier name is unfilled  | please fill out this field  	|			
			| 						 | 									| Its is update cashier name and email with empty filled	 | please fill out this field 	|
			
			