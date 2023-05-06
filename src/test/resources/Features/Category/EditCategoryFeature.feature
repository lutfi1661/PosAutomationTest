@EditCategory
Feature: feature to test add category functionality
  Scenario Outline: add new category
    Given user is on the category page
    When user find old category "<oldCategory>"
    And user click edit category icon
    Then edit category screen popped up
    And user change category name with "<newCategory>"
    And user submit new updated category
    Then updated category "<newCategory>" is showed in data table

    Examples:
      | oldCategory        | newCategory        |
      | test - Canned Food | test - Canned Meat |