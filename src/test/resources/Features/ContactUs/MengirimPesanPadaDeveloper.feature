#Author : Muhammad Rasyid Fadlurrahman
#Date	: 26/04/2023
#Description : Testing POS ContactUs Feature

@SmokeScenario
@RasyidScenario
  Feature: feature to test send message to developer functionality 
    Scenario Outline: Check send message to developer is successful
      Given browser is open
      And User already in home page
      When User clicks on contact us at the left corner
      And User enters <name> <gmail> and <message>
      And User clicks on submit button
      Then User should be able to see Your message has been sent successfully
      
      Examples: send message success
	      | name   | | gmail                     | | message           |
	      | Rasyid | | rasyidfad201101@gmail.com | | theUIissogood     |
	      
    Scenario Outline: Check send message to developer is un-successful
      Given browser is open
      And User already in home page
      When User clicks on contact us at the left corner
      And User enters <name> <gmail> and <message>
      And User clicks on submit button
      Then User should be able to see Failed to sent message
      
      Examples: send message success
	      | name    | | gmail                     | | message           |
	      | <blank> | | rasyidfad201101@gmail.com | | theUIissogood     |
	      | Rasyid  | | <blank>                   | | theUIissogood     |
	      | Rasyid  | | rasyidfad201101@gmail.com | | <blank>           |
	      | <blank> | | rasyidfad201101@gmail.com | | <blank>           |
	      