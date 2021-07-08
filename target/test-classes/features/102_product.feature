@smoke @product
Feature: Product Screen

  Background:
    Given I am on the home screen

    And a product with the following attributes:
      | id    | name       | description     | currency | price | imgUrl    |
      | HI999 | Sunny Days | Should be close | $        | 66    | image_url |

    When the product is already exist

  Scenario: Product Screen Test
    When I go to the product details

    Then the product has following attributes:
      | name        |
      | description |
      | price       |
      | image       |

    And a scrollable review list is displayed
    And I can add following review with clicking Add Review button:
      | to review or not to review... | 5 |

    And I can navigate to previous screen with back button
