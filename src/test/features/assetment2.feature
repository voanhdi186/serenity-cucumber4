@verify-three-options
Feature: Test

  Background:
    Given Open browser and start with url https://www.gobear.com/ph?x_session_type=UAT
    When Navigate to travel section
    And I am looking for single trip travel plans for 1 person(s). I am going to Hong Kong.
    And from 02-08-2019 to 11-08-2019
    And I click on button: Show my results

  @verify-filter-option
  Scenario: Verify Filter options
    When I want to select INSURERS: FPG Insurance
    Then The result page should display more than 1 card(s)
    When I want to select INSURERS: Malayan Insurance
    Then The result page should display more than 1 card(s)

  @verify-sort-option
  Scenario: Verify Sort options
    When I want to select SORT option Price: High to low
    Then Verify the price is sorted by high to low

  @verify-details-option
  Scenario: Verify Details options
    When Select travel date from = 06-08-2019
    Then  Verify summary text at the top should display: from 06 Aug 2019
    When Select Destination: Japan
    Then Verify summary text at the top should display: travel to Japan

