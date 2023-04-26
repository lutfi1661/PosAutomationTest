#Author
#Date
#Description
@NavPageProd
Feature: feature to test navigation per page product functionality

  Scenario: check navigation to table product page <page> is successful 
    Given user opened browser
    And user on table product page "<page>"
    When user clicks on table product page "<page>" button
    Then user navigated to table product page "<page>"
    
    Examples: 
      | page | 
      |    1 |      
      |    2 |
			|    3 |      


