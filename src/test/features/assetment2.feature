Feature: Test

  @assignment2
  Scenario: Assignment 2
    Given Open browser and start with url https://www.gobear.com/ph?x_session_type=UAT
    When Navigate to travel section
    And I am looking for single trip travel plans for 1 person(s). I am going to Hong Kong.
    And from 02-08-2019 to 11-08-2019
    And I click on button: Show my results
    Then The result page should display equal 23 card(s)

    When I want to select INSURERS: FPG Insurance
    When I want to select INSURERS: Malayan Insurance
    Then The result page should display equal 5 card(s)

