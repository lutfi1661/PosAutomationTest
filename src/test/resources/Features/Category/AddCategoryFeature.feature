@AddCategory
Feature: feature to test add category functionality
  Scenario Outline: add new category
    Given user is on the category page
    When user click add category button
    Then screen popped up
    And user input new category name "<category>"
    And user submit new category
    Then new category "<category>" is showed in data table

    Examples:
      | category              |
      | test - Canned Food    |



