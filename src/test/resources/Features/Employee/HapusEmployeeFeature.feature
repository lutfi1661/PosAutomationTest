#Author : Reihan Reinaldi Suryaman
#Date	: 24/04/2023
#Description : Testing GoGrids view event feature

@SmokeScenario
@ReihanScenario
  Feature: feature to test delete employee functionality
    Scenario: Check delete employee
      Given browser is open
      And user had logged in as administrator
      And there is at least one employee
      When user clicks on employee menu
      And user clicks on trash icon button on one of the employee
      And user confirm delete employee action
      Then employee selected is deleted