Feature: User Login , Add to cart and Logout functionality

  Scenario Outline: User logs in with valid credentials
    Given User navigates to SauceDemo login page
    When User enters "<username>" and "<password>"
    Then User should be redirected to the product page
    Examples:
      | username        | password      |
      | standard_user   | secret_sauce  |
      | problem_user    | secret_sauce  |

  Scenario Outline: User logs in with invalid credentials
    Given User navigates to SauceDemo login page
    When User enters "<username>" and "<password>"
    Then An error message should be displayed
    Examples:
      | username   | password   |
      | test12345  | test1234   |

  Scenario Outline: User adds a product to the cart
    Given User is logged in with "<username>" and "<password>"
    When User adds a product to the cart
    Then The cart should contain 1 product

    Examples:
      | username      | password      |
      | standard_user | secret_sauce  |

  Scenario Outline: User logs out
    Given User is logged in with "<username>" and "<password>"
    When User logs out
    Then User should be redirected to the login page

    Examples:
      | username      | password      |
      | standard_user | secret_sauce  |
