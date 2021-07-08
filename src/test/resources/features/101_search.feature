@smoke @search
Feature: Search products

  Background:
    Given I am on the home screen
    And the search input field is displayed

    And a product with the following attributes:
      | id    | name       | description     | currency | price | imgUrl    |
      | HI999 | Sunny Days | Should be close |      $  |   66   | image_url |

    When the product is already exist

  Scenario Outline: Search <testCase> <expected_result>
    When I want to search a product '<testCase>'
    Then the search '<expected_result>'

    Examples:
      | testCase                      | expected_result |
      | WITH NAME (first word)        | IS SUCCESS      |
      | WITH NAME (last word)         | IS SUCCESS      |
      | WITH NAME (all words)         | IS SUCCESS      |
      | WITH DESCRIPTION (first word) | IS SUCCESS      |
      | WITH DESCRIPTION (last word)  | IS SUCCESS      |
      | WITH DESCRIPTION (all words)  | IS SUCCESS      |