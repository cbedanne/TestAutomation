Feature: Get 1st flight and modify the description
  Scenario: client makes call to GET /flights
    When the client calls /flights
    Then the client take the first flight and the destination is Amsterdam