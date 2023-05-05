#Author: Pamudya Putra Pamungkas
#Date: 04/05/2023
#Description: Testing Accessing Instagram Account as Employee
@SmokeScenario
@MudayScenario
Feature: feature to test accessing instagram account as employee functionality

  
  Scenario: Check navigate to instagram is successful with employee access
    Given browser is open
    And user is already in home page as employee
    When user clicks on contact us button
    And user clicks on instagram button
    Then user is navigated to bleven instagram profile

  #@SmokeTest
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
