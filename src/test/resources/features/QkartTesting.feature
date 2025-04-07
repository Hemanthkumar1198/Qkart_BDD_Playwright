#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
@Smoke @Regression @EndToEnd
Feature: Complete End-to-End QKart Flow
  This feature covers the full user journey from registration to placing an order on QKart.

  Scenario Outline: Verify full flow from user registration to placing an order
    Given user is on the home page
    And user clicks on the Register button
    And user should land on the register page
    When user enters a valid username, password, and confirm password
    And user clicks on the Register Now button
    Then a registration successful message popup should appear
    And user should be navigated to the login page

    Given user is on login page
    And user enters valid username and password
    When user clicks on login button
    Then user should be able to login successfully for QKart application

    Given user is on home page
    And user searches for "<search>" and adds the "<productname>" to cart
    When user verifies that the selected product is successfully added to cart
    Then user clicks on the checkout button
    
    
    Given user is on the checkout page
    And user clicks on the Add New Address button
    When user enters "<addaddress>" and clicks on the Add button
    And user selects the address to deliver the product
    And user clicks on the Place Order button
    Then the message "<orderplacedconfirmationtxt>" should appear confirming the order is placed

    Examples:
      | addaddress                           				| orderplacedconfirmationtxt  | search | productname                      |
      | Last town of Peace @571113 | Yay! It's ordered           | shoe   | Roadster Mens Running Shoes      |
