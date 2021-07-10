@smoke @api @updateProduct
Feature: Update Product - api

  Background:

    Given a product with the following attributes:
      | id    | name       | description     | price | currency | imgUrl    |
      | HI999 | Sunny Days | Should be close | 66    | $        | image_url |

    When the product is already exist

  Scenario Outline: Update product <testCase> <expectedResult>

    And I want to update a product with the following attributes:
      | id   | name   | description   | currency   | price   | imgUrl   |
      | <id> | <name> | <description> | <currency> | <price> | <imgUrl> |

    When I save the product '<testCase>'
    Then the save '<expectedResult>'

    Examples:
      | testCase                         | expectedResult | id    | name        | description        | currency | price | imgUrl        |
      | WITHOUT ID                       | FAILS          |       | Cloudy Days | Not going anywhere | $        | 99    | new_image_url |
      | WITHOUT NAME                     | FAILS          | HI999 |             | Not going anywhere | $        | 99    | new_image_url |
      | WITHOUT DESCRIPTION              | FAILS          | HI999 | Cloudy Days |                    | $        | 99    | new_image_url |
      | WITHOUT CURRENCY                 | FAILS          | HI999 | Cloudy Days | Not going anywhere |          | 99    | new_image_url |
      | WITHOUT PRICE                    | FAILS          | HI999 | Cloudy Days | Not going anywhere | $        |       | new_image_url |
      | WITHOUT IMAGE URL                | FAILS          | HI999 | Cloudy Days | Not going anywhere | $        | 99    |               |
      | WITH ALL REQUIRED FIELDS         | IS SUCCESSFUL  | HI999 | Cloudy Days | Not going anywhere | $        | 99    | new_image_url |
      | WITH EXISTING PRODUCT ATTRIBUTES | FAILS          | HI999 | Cloudy Days | Not going anywhere | $        | 99    | new_image_url |

