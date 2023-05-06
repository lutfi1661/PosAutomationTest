#Author
#Date
#Description
@ExcelCategory
Feature: feature to test download data excel category functionality

  @ExcelCategory
  Scenario Outline: Check Excel button download Excel file successfully on page <page>
    Given User excel category has opened the browser
    And User excel category already in home page
    When User excel category clicks sidebar submenu Category
    And User excel category clicks Download Excel button on page "<page>"
    Then File Excel Downloaded Succesfully

    Examples: 
      | page |
      |    1 |
      |    2 |
      |    3 |
