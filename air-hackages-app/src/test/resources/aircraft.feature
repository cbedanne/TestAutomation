Feature: Get all the aircrafts

  Scenario: client makes call to GET /aircrafts
    Given We have the following aircrafts in the database
      | 1 | AH111 | Boeing 777 |
      | 2 | AH102 | Airbus A380 |
    When the client calls /aircrafts
    Then the client receives status code of 200
    And the number of aircrafts is 2

  Scenario: client makes call to POST /aircrafts a new aircraft is in the database
    Given We have the following aircrafts in the database
      | 1 | AH345 | Boeing 777 |
      | 2 | AH200 | Airbus A380 |
      | 3 | AH900 | Boeing 767 |
    When the client calls POST /aircrafts with code AH112 and description AirbusA365
    When the client calls /aircrafts
    Then the client receives status code of 200
    And the number of aircrafts is 4

  Scenario: client makes call to GET /aircrafts
    Given We have the following aircrafts in the database
      | 1 | AH111 | Boeing 777 |
      | 2 | AH102 | Airbus A380 |
    When the client calls /aircrafts/AH107
    Then the description of AH107 is modify