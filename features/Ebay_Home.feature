
  Feature: Ebay Home Page Scenarios

    Scenario: Advance Search Link

      Given I am on the Ebay Home Page

      When I click on Advance Link

      Then I navigate to Advance Search Page

    Scenario: Search items count

      Given I am on the Ebay Home Page

      When I search for iPhone 11

      Then I validate at least 1000 search items present


