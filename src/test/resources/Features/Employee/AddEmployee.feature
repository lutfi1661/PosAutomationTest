#Author : Lamda Richo Vanjaya Sumaryadi
#Date	: 23/04/2023
#Description : Testing in Add Employee POS

@AddEmployee
Feature: Feature to check add employee is successful with valid credentials
	
	#For TC 1	
	@AddEmployee1
	Scenario Outline: Check add employee is successful with valid credentials
		Given browser employee is opened
		And user employee is on home page
		And clicks on employee button
		And user clicks button add employee
		And user is showed modal pop up add employee
		When user enters "Lamda", "lamda@gmail", "123456", and "123456"
		And user click button Add
		Then user should see the add employee success notification
    And modal pop up should be closed automatically
    
  #For TC 2-5
	@AddEmployee2
	Scenario Outline: Check add employee is un-successful with invalid credentials. <condition>	
		Given browser employee is opened
		And user employee is on home page
		And clicks on employee button
		And user clicks button add employee
		And user is showed modal pop up add employee
		When user enters "<name>", "<email>", "<password>", and "<confirm_password>"
		And user click button Add
		Then user should be able to see "<unsuccessReason>" notification
		
	Examples:
	  	| name   			| email             | password | confirm_password | condition													  																							| unsuccessReason														|
		  | ,./&)(^  		| lamda@gmail.com   | 123456   | 123456           | Its is name with special characters 																							| the add employee unsuccess								|		
		  | Lamda				| lamdagmail.com		| 123456   | 123456						| Its is email invalid, but another field is correct 																| Email field is wrong											|
		  | Lamda				| lamda@gmail.com		| 123456   | 1								| Its is confirm password is different with password 																| password and confirm password must match 	|			
			| 						| lamda@gmail.com		| 			   | 									| Its is cashier name, password, and confirm password is empty but email is filled 	| please fill out this field 	              |