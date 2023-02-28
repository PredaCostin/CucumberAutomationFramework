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

  @Run
  Scenario Outline: Home page links

    Given I am on the Ebay Home Page

    When I click on '<link>'

    Then I validate that page navigate to '<url>' and title contains '<title>'

    Examples:
      | link        | url                                                          | title                    |
      | Motors      | https://www.ebay.com/b/Auto-Parts-Accessories/6028/bn_569479 | Auto Parts & Accessories |
      | Electronics | https://www.ebay.com/b/Electronics/bn_7000259124             | Electronics products     |
