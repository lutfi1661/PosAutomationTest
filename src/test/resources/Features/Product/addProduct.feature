#Author
#Date
#Description
@AddProduct
Feature: feature to test add product functionality

  @AddProduct1
  Scenario: Add product is successful with valid credentials
    Given User has opened the application
    And User has navigated on Product page
    And User show modal pop up add product
    When User clicks add product button
    And User enters "C:/Users/sylvia/Pictures/cadbury.jpg", "13692", "Cadbury", "Chocolate", "29/04/2025", "1500", "12000", and "15000"
    Then User should be able to see add product success notification
    And Modal pop up closed automatically and user can see added product

  @AddProduct2
  Scenario Outline: Add product is un-successful with invalid credentials
    Given User has opened the application
    And User has navigated on Product page
    And User show modal pop up add product
    When User clicks add product button
    And User enters "<image>", "<productCode>", "<productName>", "<category>", "<expireDate>", "<stocks>", "<capitalPrice>", and "<price>"
    Then User should be able to see add product fail notification
    And User still can view modal pop up

    Examples: 
      | image                                        | productCode | productName | category  | expireDate | stocks | capitalPrice | price  |
      | C:/Users/sylvia/Pictures/cadbury.jpg | satuduatiga | Cadbury     | Chocolate | 29/04/2025 | ****   | murah        | seribu |
      | C:/Users/sylvia/Pictures/cadbury.jpg |       13692 |             | Chocolate | 29/04/2025 |   1500 |        12000 |  15000 |
      | C:/Users/sylvia/Pictures/cadbury.jpg |       13692 | **&@        | Chocolate | 29/04/2025 |   1500 |        12000 |  15000 |
      | C:/Users/sylvia/Pictures/cadbury.jpg |             |             |           |            |        |              |        |
