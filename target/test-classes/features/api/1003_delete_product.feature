@smoke @api @deleteProduct_api
Feature: Update Product - api

  Background:

    Given a product with the following attributes:
      | id    | name       | description     | price | currency | imgUrl    |
      | HI999 | Sunny Days | Should be close | 66    | $        | image_url |

    When the product is already exist
  Scenario: DELETE BY ID

    When I want to delete product by id 'HI999'
    Then the delete 'IS SUCCESSFUL'
