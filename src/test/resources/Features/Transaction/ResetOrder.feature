#Author				: Mochammad Lutfi Faturachman
#Date					: May 1st, 2023
#Description 	: Adding Order in Transaction POS
@SmokeScenario @LutfiScenario
Feature: Add order list to cart table on transaction page

  Scenario Outline: Add order with correct product code
    Given browser is open
    And User is already on transaction page as employee
    And User enters <product_code> on search bar
    And User clicks add button
    Then User should be able to see Success message
    And User clicks reset button
    Then User is unable to see item on order list

    Examples: 
      | product_code |
      |           40 |
