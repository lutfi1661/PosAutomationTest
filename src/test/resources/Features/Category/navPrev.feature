#Author
#Date
#Description
@NavPrevCat
Feature: feature to test navigation previous category functionality

  @NavPrevCat1
  Scenario Outline: check navigation previous is successful on table category page <page>
    Given user is open browser
    And user is on category page
    When clicks on table category page "<page>"
    And clicks previous button on table category
    Then user is navigated to the table category page "<prevPage>"

    Examples: 
      | page | prevPage |
      |    2 |        1 |
      |    3 |        2 |
   
 @NavPrevCat2
  Scenario: check navigation previous is un-successful on table category page 1
    Given user is open browser
    And user is on category page
    When clicks previous button on table category
    Then user still in table category page 1