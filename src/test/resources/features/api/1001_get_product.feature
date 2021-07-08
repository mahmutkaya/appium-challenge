@smoke @api @getProduct_api
Feature: Get Product - api

  Background:

    Given a product with the following attributes:
      | id    | name       | description     | price | currency | imgUrl    |
      | HI999 | Sunny Days | Should be close | 66    | $        | image_url |

    When the product is already exist

  Scenario: GET BY ID

    When I want to get product by id 'HI999'
    Then the get 'IS SUCCESSFUL'
    And following product is returned:
      | id    | name       | description     | price | currency |imgUrl    |
      | HI999 | Sunny Days | Should be close | 66    | $        |image_url |
