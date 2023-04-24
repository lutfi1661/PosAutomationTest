#Author
#Date
#Description
@NavNextProd
Feature: feature to test navigation next product functionality

  @NavNextProd1
  Scenario: check navigation previous is successful on table product page <page>
    Given user open browser
    And user is on table product page "<page>"
    When clicks next button on table product
    Then user is navigated to table product page "<nextPage>"
    
    Examples: 
      | page | nextPage |
      |    1 |        2 |
      |    2 |        3 |

  @NavNextProd2
  Scenario Outline: check navigation next is un-successful on table product page 3
    Given user open browser
    And user is on table product page "3"
    When clicks next button on table product
    Then user still on table product page 3
