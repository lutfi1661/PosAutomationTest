#Author
#Date
#Description
@EditProduct
Feature: feature to test edit product functionality

  @EditProduct1
  Scenario: Edit product is successful with valid credentials
    Given User edit product has opened the application
    And User edit product has navigated on Product page
    When User edit product clicks edit product button
    And User edit product show modal pop up edit product
    And User edit product enters "C:/Users/sylvia/Pictures/cadbury.jpg", "136921", "Cadbury Diary Milk", "Chocolate", "29/04/2025 ", "1000", "15000", and "17000"
    Then User edit product should be able to see add product success notification
    And Modal pop up closed automatically and user edit product can see edited product

  @AddProduct2
  Scenario Outline: Edit product is un-successful with invalid credentials
    Given User edit product has opened the application
    And User edit product has navigated on Product page
    And User edit product show modal pop up edit product
    When User edit product clicks edit product button
    And User edit product enters "<image>", "<productCode>", "<productName>", "<category>", "<expireDate>", "<stocks>", "<capitalPrice>", and "<price>"
    Then User edit product should be able to see edit product fail notification
    And User edit product still can view modal pop up

    Examples: 
      | image                                | productCode | productName        | category  | expireDate | stocks | capitalPrice | price  |
      | C:/Users/sylvia/Pictures/cadbury.jpg | satuduatiga | Cadbury Diary Milk | Chocolate | 29/04/2025 | ****   | murah        | seribu |
      | C:/Users/sylvia/Pictures/cadbury.jpg |      136921 |                    | Chocolate | 29/04/2025 |   1000 |        15000 |  17000 |
      | C:/Users/sylvia/Pictures/cadbury.jpg |      136921 | **&@               | Chocolate | 29/04/2025 |   1000 |        15000 |  17000 |
      | C:/Users/sylvia/Pictures/cadbury.jpg |             |                    |           |            |        |              |        |
