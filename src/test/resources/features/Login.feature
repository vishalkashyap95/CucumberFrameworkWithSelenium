@Login
Feature: Open Source CMS login cases

  Background:
    Given Open Browser and navigate to Login page

  Scenario: Verify Post page
    Given Login with valid credentials
    Then click on post menu
    Then verify title of Post page
    Then verify all links under post menu
    Then click logout and verify user redirected to login page


  Scenario: : Test Login functionality with valid data
    When Enter valid uesrname and valid password
      | username      | password      |
      | xyz           | abc           |
      | asd           | opensourcecms |
      | opensourcecms | kmdns         |
      | opensourcecms | opensourcecms |
    Then user should be able to login successfully
#    Examples:
#      | username      | password      |
#      | opensourcecms | opensourcecms |
