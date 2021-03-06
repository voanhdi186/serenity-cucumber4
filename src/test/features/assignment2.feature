@verify-three-option
Feature: GB Assignment 2

  Background:
    Given Open browser and start with url https://www.gobear.com/ph?x_session_type=UAT
    When Navigate to travel section
    And I am looking for single trip travel plans for 1 person(s). I am going to Hong Kong.
    And from 02-08-2019 to 11-08-2019
    And I click on button: Show my results

  @verify-filter-option
  Scenario: Verify Filter options
    Then The result page should display greater_than 3 card(s)
    When I want to select INSURERS: FPG Insurance
    Then The result page should display less_than 23 card(s)
    When I want to select INSURERS: Malayan Insurance
    Then The result page should display greater_than 2 card(s)
    When I want to select INSURERS: STARR
    Then The result page should display equal 7 card(s)
    When I want to result page display Promotion: Promos only
    Then The result page should display equal 0 card(s)
    When I want to result page display Promotion: Show all
    Then The result page should display equal 7 card(s)
    And Close browser

  @verify-filter-more-option
  Scenario Outline: Verify Filter More options
    When I want to extend for more options in filter
    And Slide the bar <slider> to <percent> percent
    Then The result page should display <operator> <result> card(s)
    And Close browser
    Examples:
      |slider                               |percent  |operator       |result         |
      |Personal Accident                    |10       |equal          |22             |
      |Medical expenses while traveling     |20       |equal          |10             |
      |Trip cancellation                    |30       |equal          |12             |
      |Trip termination                     |40       |equal          |14             |
      |Loss of baggage & personal belongings|80       |equal          |0              |

  @verify-sort-option
  Scenario: Verify Sort options
    When I want to select SORT option Price: High to low
    Then Verify the price is sorted by high to low
    When I want to select SORT option Price: Low to high
    Then Verify the price is sorted by low to high
    When I want to select SORT option Coverage Score: High to low
    Then Verify coverage score is sorted by high to low
    When I want to select SORT option Review score: High to low
    Then Verify review score is sorted by high to low
    When I want to select SORT option Insurer: A to Z
    Then Verify cards are sorted by A to Z
    When I want to select SORT option Insurer: Z to A
    Then Verify cards are sorted by Z to A
    And Close browser

  @verify-details-option
  Scenario: Verify Details options
    When I want to add 3 Destination
    Then I should see there are total 4 destinations
    
    When I want to remove 2 Destination
    Then I should see there are total 2 destinations

    When I want to select POLICY TYPE=annual trip
    And I should see there are total 1 destinations
    And I want to select number of person for the trip: 2 persons
    And Select Destination: Worldwide
    And Select travel date from = 06-08-2019
    Then Verify summary text at the top should display: annual trip
    Then Verify summary text at the top should display: for 2 persons
    Then Verify summary text at the top should display: from 06 Aug 2019
    Then Verify summary text at the top should display: travel to Worldwide
    And Close browser

