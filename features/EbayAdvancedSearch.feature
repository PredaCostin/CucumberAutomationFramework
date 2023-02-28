Feature: Ebay Advance Search Page

  Scenario: Ebay Logo on Advanced Search Page

    Given I am Ebay Advance Search Page

    When I click on Ebay Logo

    Then I am navigated to Ebay Home Page

  Scenario: Advance search an item

    Given I am Ebay Advance Search Page

    When I advanced search an item

      | keywork   | excludeWord | minAmount | maxAmount |
      | iPhone 11 | refurbished | 300       | 900       |