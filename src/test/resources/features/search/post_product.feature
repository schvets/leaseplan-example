Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/test/{product} for getting the products.
### Available products: "apple", "mango", "tofu", "water"
### Prepare Positive and negative scenarios

  Scenario Outline: Verify search product request (positive flow)
    Given user perform search request for <productName>
    Then user should get 200 response code
    And response should return at least 1 PRODUCT entity

    Examples:
      | productName |
      | apple       |
      | mango       |
      | tofu        |
      | water       |


  Scenario Outline: Verify search product request (negative flow - unavailable item)
    Given user perform search request for <productName>
    Then user should get 404 response code
    And user should get ERROR with data:
      | error | message   | requested_item   | served_by            |
      | true  | Not found | <productName> | https://waarkoop.com |

    Examples:
      | productName |
      | car              |
      | test             |


  Scenario Outline: Verify search product request (negative flow - wrong search param)
    Given user perform search request for <productName>
    Then user should get 401 response code
    And user should get ERROR with data with message "Not authenticated"

    Examples:
      | productName |
      |             |
