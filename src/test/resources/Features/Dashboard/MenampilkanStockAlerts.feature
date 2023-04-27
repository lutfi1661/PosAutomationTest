#Author : Aqil Rahman
#Date	: 26/04/2023
#Description : Testing Stock Alert Feature in Dashboard POS

@DashboardStockAlert
Feature: Feature to check stock alert in dashboard

	#For TC 1
  @DashboardStockAlert1
  Scenario: Check data stock alert is showed on dashboard page
    Given browser dashboard is opened
    When user is on dashboard page
    Then user should be able to see data stock alert in product page
	
	#For TC 2 & 3
  @DashboardStockAlert2
  Scenario Outline: Check data stock alert is showed on dashboard page within <condition>
    Given browser dashboard is opened
    And user is on dashboard page
    And user dashboard clicks on product button
    And user dashboard has navigated on the product page
    And user dashboard has click button add product
    When user dashboard enters "<image>", "<productCode>", "<productName>", "<category>", "<expireDate>", "<stocks>", "<capitalPrice>", and "<price>"
		And user dashboard clicks on add products button
		And user dashboard go back to dashboard page
    Then user should "<conclusion>" able to see new product in data stock alert, same with "<productName>"
 	
 		Examples: 
      | image                                        		 | productCode  | productName         | category  | expireDate  | stocks  | capitalPrice  | price  | condition                          | conclusion  |
      | C:/Users/aqil/Downloads/TorabikaCreamyLatte.jpg  | 9845  			  | TorabikaCreamyLatte | Coffe		  | 02/05/2023  | 24      | 10000         | 12500  | add product and the stock is < 100 | be          |
      | C:/Users/aqil/Downloads/Torabika.jpg             | 9843         | torabika            | Coffe     | 02/05/2023  | 101     | 10000         | 12500  | add product and the stock is > 100 | not be      |
 		
 	#For TC 4
 	@DashboardStockAlert3
 	Scenario: Check if login with cashier account, whether data stock alert is does not exist
 		Given browser dashboard is opened
 		When user cashier is on transaction page
 		Then user cashier should not be able to see the component data stock alert
 		

    