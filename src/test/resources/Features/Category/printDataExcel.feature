#Author
#Date
#Description
@PrintCategory
Feature: feature to test print data category functionality

  @PrintCategory
  Scenario Outline: Check if the Print button work successfully on page <page>
    Given User print category has opened the browser
    And User print category already in home page
    When User print category clicks sidebar submenu Category
    And User print category clicks Download Print button on page "<page>"
    Then File Printed Succesfully

    Examples: 
      | page |
      |    1 |
      |    2 |
      |    3 |
