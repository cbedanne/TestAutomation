Feature: Tests for /flights endpoint

  Scenario: client makes call to GET /flights
    When the client calls /flights
    Then the client receives status code of 200

  Scenario: client makes call to GET /flights
    When the client calls /flights
    Then the client take the first flight and the destination is Amsterdam

  Scenario: client makes call to GET /flights
    When the client calls /flights
    Then the client take the first flight and the origin is Paris

  Scenario: client makes call to GET /flights/origin/Paris
    When the client calls /flights/origin/Paris
    Then all the flights origin is Paris

  Scenario: client makes call to GET /flights/origin/Amsterdam
    When the client calls /flights/origin/Amsterdam
    Then all the flights origin is Amsterdam

  Scenario: client makes call to GET /flights/destination/Paris
    When the client calls /flights/destination/Paris
    Then all the flights destination is Paris

  Scenario: client makes call to GET /flights/destination/Amsterdam
    When the client calls /flights/destination/Amsterdam
    Then all the flights destination is Amsterdam