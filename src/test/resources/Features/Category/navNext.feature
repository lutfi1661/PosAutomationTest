#Author
#Date
#Description
@NavNextCat
Feature: feature to test navigation next category functionality

  @NavNextCat1
  Scenario: check navigation previous is successful on table category page <page>
    Given user opened browser
    And user is on table category page "<page>"
    When clicks next button on table category
    Then user is navigated to table category page "<nextPage>"
    
    Examples: 
      | page | nextPage |
      |    1 |        2 |
      |    2 |        3 |

  @NavNextCat2
  Scenario Outline: check navigation next is un-successful on table category page 3
    Given user opened browser
    And user is on table category page "3"
    When clicks next button on table category
    Then user still on table category page 3
