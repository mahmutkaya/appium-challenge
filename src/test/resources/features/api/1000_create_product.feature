@smoke @api @createProduct_api
Feature: Create Product - api

  Scenario Outline: Create product <testCase> <expectedResult>

    Given I want to create a product with the following attributes:
      | id   | name   | description   | currency   | price   | imgUrl   |
      | <id> | <name> | <description> | <currency> | <price> | <imgUrl> |

    When I save the new product '<testCase>'
    Then the save '<expectedResult>'

    Examples:
      | testCase                         | expectedResult | id    | name       | description     | currency | price | imgUrl    |
      | WITHOUT ID                       | FAILS          |       | Sunny Days | Should be close | €        | 66    | image_url |
      | WITHOUT NAME                     | FAILS          | HI999 |            | Should be close | €        | 66    | image_url |
      | WITHOUT DESCRIPTION              | FAILS          | HI999 | Sunny Days |                 | €        | 66    | image_url |
      | WITHOUT CURRENCY                 | FAILS          | HI999 | Sunny Days | Should be close |          | 66    | image_url |
      | WITHOUT PRICE                    | FAILS          | HI999 | Sunny Days | Should be close | €        |       | image_url |
      | WITHOUT IMAGE URL                | FAILS          | HI999 | Sunny Days | Should be close | €        | 66    |           |
      | WITH ALL REQUIRED FIELDS         | IS SUCCESSFUL  | HI999 | Sunny Days | Should be close | €        | 66    | image_url |
      | WITH EXISTING PRODUCT ATTRIBUTES | FAILS          | HI999 | Sunny Days | Should be close | €        | 66    | image_url |

