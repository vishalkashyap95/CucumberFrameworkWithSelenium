@Login
Feature: Open Source CMS login cases

  Background:
    Given Open Browser and navigate to Login page

  Scenario: : Test Login functionality with valid data
    When Enter valid uesrname and valid password
      | username      | password      |
      | xyz           | abc           |
      | asd           | opensourcecms |
      | opensourcecms | kmdns         |
      | opensourcecms | opensourcecms |
    Then user should be able to login successfully
#    Then close the browser
#    Examples:
#      | username      | password      |
#      | opensourcecms | opensourcecms |


  Scenario: Verify Post page
    Given click on post menu
    Then verify title of Post page
    Then verify all links under post menu