Feature: Get 1st aircraft and modify the description
  Scenario: client makes call to GET /aircrafts
    When the client calls /aircrafts
    Then the client take the first one
  Scenario: client makes call to GET /aircrafts
    When the client calls /aircrafts/AH107
    Then the description of AH107 is modify