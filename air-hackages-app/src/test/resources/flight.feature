Feature: Get all day flights
  Scenario: client makes call to GET /flights
    When the client calls /flights
    Then the client receives status code of 200
  Scenario: client make call to GET /flights/1
    When the client calls /flights/1
    Then the client receives status code of 404