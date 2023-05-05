#Author: Pamudya Putra Pamungkas
#Date: 04/05/2023
#Description: Testing Editing User Profile as Employee

@SmokeScenario
@MudayScenario
Feature: feature to test editing user profile as employee functionality

  
  Scenario Outline: Check editing user full name as employee is successful
    Given browser is open
    And user is already in home page as employee
    When user clicks on profile
    And user clicks on edit profile button
    And user inputs <fullname>
    And user clicks on save changes button
    And profile updated notification is shown
    And user clicks on back button
    Then now user full name is the same as <fullname>
    

    Examples: 
      | fullname     |
      | Putri        |
      | putri123     |
      | putri!!      |
      | putriputra   |
      | putra        |
