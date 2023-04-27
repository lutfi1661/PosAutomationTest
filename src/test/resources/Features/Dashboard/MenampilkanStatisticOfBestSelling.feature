#Author : Aqil Rahman
#Date	: 27/04/2023
#Description : Testing Statistic of Best Selling Feature in Dashboard POS

@StatisticOfBestSellingDashboard
Feature: Feature to check Statistic of Best Selling in dashboard

	#For TC 1
  @StatisticOfBestSellingDashboard1
  Scenario: Check whether component statistic of best selling is does not exist
    Given browser dashboards is opened
    When user dashboards is on dashboard page
    Then user should be able to see the component statistic of best selling 

#	For TC 2
  @StatisticOfBestSellingDashboard2
  Scenario: Check if when the total filter is clicked, the total data will not be displayed.
    Given browser dashboards is opened
    When user dashboards is on dashboard page
    Then user click button total
 
#For TC 3
  @StatisticOfBestSellingDashboard3
  Scenario: Check if login with cashier account, wheter component statistic of best selling is doesn't exist
    Given browser dashboards is opened
    When cashiers is on transaction page
    Then user should not be able to see the component statistic of best selling 

    
