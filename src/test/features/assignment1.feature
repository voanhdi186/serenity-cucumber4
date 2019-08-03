@verify-three-option
Feature: GB Assignment 1:
  Test plan:

  SCOPE:
  Automate regression test for "Travel Insurance" feature.

  TASK:
  . Collect all regression test cases need to be automated, and can be automated.
  . Set strategy, priority for test cases to be automated
  . Prepare environments that automation will be run on
  . Set schedule for execute automated test
  . Test report (environment, result, time duration..)

  TOOLS used::
  . Cucumber (BDD tools) will be used as test script
  . Jenkin for execute automation.
  . Testlink for test result and report.

  Architecture of test script:
  . Cucumber (BDD tools) will be used as test script
  . Script should accept parameters, in order to be able to be reused as much as possible.
  . All test cases in a page should be stored in the same feature file
  . Each test case should be stored as Scenario
  . Tag annotation should be used as flag when execute automation
  . Tag annotation should be used as parameter for updating test result automatically on Testlink
  . Keyword “And” should be used when keyword on current line is the same with previous line
  . Keyword “Then” should be used whenever the step validates an expected result
  . Using Page Object Model for store web elements, methods
  . Config file should be separated for:
    _ Environments
    _ DB connect + SQL query
    _ Template format: csv, json…
    _ Resources: image, file

