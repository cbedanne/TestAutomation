Feature: Get all day flights
  Scenario: client makes call to GET /aircrafts
    When the client calls /aircrafts
    Then the client receives status code of 200