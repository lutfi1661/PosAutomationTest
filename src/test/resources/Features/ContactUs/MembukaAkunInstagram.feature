#Author : Muhammad Rasyid Fadlurrahman
#Date	: 26/04/2023
#Description : Testing POS ContactUs Feature

@SmokeScenario
@RasyidScenario
  Feature: feature to test navigate to POS instagram functionality
    Scenario: Check navigate to instagram is successful
      Given browser is open
      And User already in home page
      When User clicks on contact us at the left corner
      And User clicks on instagram logo
      Then User is navigated to the bleven instagram page