@smoke @home
Feature: Home Screen

  Scenario: Home Screen Elements
    When I am on the home screen

    Then header is displayed
    And the search input field is displayed

    And the more options dropdown is displayed
    And the more options dropdown has following options:
      | Settings |

    And the products have following attributes:
      | name        |
      | description |
      | price       |
      | image       |