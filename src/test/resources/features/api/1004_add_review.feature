@smoke @api @addReview_api
Feature: Add Review - api

  Background:
    Given a product with the following attributes:
      | id    | name       | description     | price | currency | imgUrl    |
      | HI999 | Sunny Days | Should be close | 66    | $        | image_url |

    When the product is already exist

  Scenario Outline: Add review <testCase> <expectedResult>
    Given I want to add a review with the following attributes:
      | productId   | locale   | rating   | text   |
      | <productId> | <locale> | <rating> | <text> |

    When I save the new review '<testCase>'
    Then the add review '<expectedResult>'

    Examples:
      | testCase                 | expectedResult | productId | locale | rating | text                          |
      | WITHOUT RATING           | FAILS          | HI999     | en     |        | to review or not to review... |
      | WITHOUT TEXT             | FAILS          | HI999     | en     | 5      |                               |
      | WITH ALL REQUIRED FIELDS | IS SUCCESSFUL  | HI999     | en     | 5      | to review or not to review... |

