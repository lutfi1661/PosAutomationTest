#Author
#Date
#Description
@NavPageCat
Feature: feature to test navigation per page category functionality

  Scenario: check navigation to table category page <page> is successful 
    Given user is opened browser
    And user on table category page "<page>"
    When user clicks on table category page "<page>" button
    Then user navigated to table category page "<page>"
    
    Examples: 
      | page | 
      |    1 |      
      |    2 |
			|    3 |      


