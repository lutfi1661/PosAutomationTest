#Author : Reihan Reinaldi Suryaman
#Date	: 24/04/2023
#Description : Testing GoGrids view event feature

@SmokeScenario
@ReihanScenario
Feature: Feature to test expired soon info on dashboard
    Scenario: Check the presence of expired soon section
      Given browser is open
      When user is logging in as admin
      Then user should be able to see expired soon section
