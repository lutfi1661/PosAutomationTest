#Author				: Mochammad Lutfi Faturachman
#Date					: May 1st, 2023
#Description 	: Adding Order in Transaction POS
@AddOrder
Feature: Add order list to cart table on transaction page

	@AddOrder1
  Scenario Outline: Add order with correct product code
    Given browser is open
    And User is already on transaction page as employee
    And User enters <product_code> on search bar
    And User clicks add button
    Then User should be able to see Success message

    Examples: 
      | product_code |
      |           40 |
	@AddOrder2
  Scenario Outline: Add order with incorrect product code
    Given browser is open
    And User is already on transaction page as employee
    And User enters <product_code> on search bar
    And User clicks add button
    Then User should be able to see Failed message

    Examples: send message success
      | product_code |
      |           90 |
