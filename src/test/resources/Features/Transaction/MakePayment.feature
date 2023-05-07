@MakePayment
Feature: Make payment for orders

  Scenario Outline: Checking "Proceed" button response
    Given browser is open
    And User is already on transaction page as employee
    And User enters <product_code> on search bar
    And User clicks add button
    Then User should be able to see Success message
    When the user clicks the "Proceed" button on the transaction page
    Then the user should be able to see an invoice modal

  Scenario Outline: Checking invoice modal information
    Given browser is open
    And User is already on transaction page as employee
    And User enters <product_code> on search bar
    And User clicks add button
    Then User should be able to see Success message
    When the user clicks the "Proceed" button on the transaction page
    Then the user should be able to see the date, total amount, and order list of the products

  Scenario Outline: Making a payment
    Given browser is open
    And User is already on transaction page as employee
    And User enters <product_code> on search bar
    And User clicks add button
    Then User should be able to see Success message
    When the user clicks the "Proceed" button on the transaction page
    Then the user should be able to see the date, total amount, and order list of the products
    When the user clicks the "Pay" button on the invoice modal
    Then the user should receive a notification that the transaction and payment have been successful
