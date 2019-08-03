@verify-three-option
Feature: Test

  Background:
    Given Open browser and start with url https://www.gobear.com/ph?x_session_type=UAT
    When Navigate to travel section
    And I am looking for single trip travel plans for 1 person(s). I am going to Hong Kong.
    And from 02-08-2019 to 11-08-2019
    And I click on button: Show my results

  @verify-filter-option
  Scenario: Verify Filter options
#    When I want to select INSURERS: FPG Insurance
#    Then The result page should display less_than 23 card(s)
#    When I want to select INSURERS: Malayan Insurance
#    Then The result page should display more_than 2 card(s)
#    When I want to select INSURERS: STARR
#    Then The result page should display equal 7 card(s)
#    When I want to result page display Promotion: Promos only
#    Then The result page should display equal 0 card(s)
#    When I want to result page display Promotion: Show all
#    Then The result page should display equal 7 card(s)
#    And Close browser

  @verify-filter-more-option
  Scenario: Verify Filter More options
#    When I want to extend for more options in filter
#    And Slide the bar Personal Accident to 10 percent
#    Then The result page should display equal 22 card(s)
#    And Slide the bar Medical expenses while traveling to 10 percent
#    Then The result page should display equal 19 card(s)
#    And Slide the bar Trip cancellation to 10 percent
#    Then The result page should display equal 11 card(s)
#    And Slide the bar Trip termination to 20 percent
#    Then The result page should display equal 10 card(s)
#    And Slide the bar Loss of baggage & personal belongings to 10 percent
#    Then The result page should display equal 6 card(s)
#    And Close browser

  @verify-sort-option
  Scenario: Verify Sort options
    When I want to select SORT option Price: High to low
    Then Verify the price is sorted by high to low
    And Close browser

  @verify-details-option
  Scenario: Verify Details options
    When Select travel date from = 06-08-2019
    Then  Verify summary text at the top should display: from 06 Aug 2019
    When Select Destination: Bolivia
    Then Verify summary text at the top should display: travel to Bolivia
    And Close browser

