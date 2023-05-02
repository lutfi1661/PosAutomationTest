#Author : Rusyda Jasmine Rachmat
#Date : 28/04/2023
#Description : Testing in Expire Soon in Product

@ExpSoon
Feature: feature to test displaying data expire soon functionality

  @ExpSoon1
  Scenario: check data expired soon is showed on product page
    Given user has opened the browser
    And user on the dashboard page
    When user clicks product button
    Then user is navigated to the product page
    And user should be able to see product data expire soon

  @ExpSoon2
  Scenario Outline: check data expired soon is showed on product page <conditions>
    Given user has opened the browser
    And user on the product page
    And user clicks add product button
    And user has showed modal pop up add product
    When user enters "<image>", "<productCode>", "<productName>", "<category>", "<expireDate>", "<stocks>", "<capitalPrice>", and "<price>"
    And user clicks on add products button
    Then user should be "<ability>" to see product "<productName>" in data expire soon

    Examples: 
      | image                                   | productCode | productName | category | expireDate | stocks | capitalPrice | price | ability  | conditions                                           |
      | C:/Users/mirva/Downloads/ultramilk.jpeg |        1231 | ultramilk   | Milk     | 30/05/2023 |    200 |         1200 |  2500 | able     | within add product and the expire date is < 180 days |
      | C:/Users/mirva/Downloads/ultramilk.jpeg |        1232 | ultramilk2  | Milk     | 30/04/2024 |    200 |         1200 |  2500 | not able | within add product and the expire date is > 180 days |
