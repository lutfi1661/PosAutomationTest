#Author
#Date
#Description
@NavPrevProd
Feature: feature to test navigation previous product functionality

  @NavPrevProd1
  Scenario Outline: check navigation previous is successful on table product page <page>
    Given user is open browser
    And user is on product page
    When clicks on table product page "<page>"
    And clicks previous button on table product
    Then user is navigated to the table product page "<prevPage>"

    Examples: 
      | page | prevPage |
      |    2 |        1 |
      |    3 |        2 |
   
 @NavPrevProd2
  Scenario: check navigation previous is un-successful on table product page 1
    Given user is open browser
    And user is on product page
    When clicks previous button on table product
    Then user still in table product page 1