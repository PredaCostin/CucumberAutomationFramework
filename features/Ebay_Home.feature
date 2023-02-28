Feature: Ebay Home Page Scenarios

  Scenario: Advance Search Link

    Given I am on the Ebay Home Page

    When I click on Advance Link

    Then I navigate to Advance Search Page

  Scenario: Search items count

    Given I am on the Ebay Home Page

    When I search for 'iPhone11'

    Then I validate at least 1000 search items present

  Scenario: Search items count2

    Given I am on the Ebay Home Page

    When I search for 'Cars'

    Then I validate at least 100 search items present

  Scenario: Search an item in category

    Given I am on the Ebay Home Page

    When I search for 'Books' in 'Books' category
