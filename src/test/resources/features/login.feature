Feature: Login

  Scenario: The user logs into the application
    Given the user goes to the login page
    When the user sets the correct credentials
    Then the "PIM" page should be displayed

  Scenario: The user is not able to log in without a password
    Given the user goes to the login page
    When the user enters only the username
    Then the user should receive and required field message

  Scenario: The user is not able to log in without a username
    Given the user goes to the login page
    When the user enters only the password
    Then the user should receive and required field message

  Scenario: The user receives an alert when enters wrong credentials
    Given the user goes to the login page
    When the user sets the wrong credentials
    Then the user should receive and invalid credential message

  Scenario: The user logs out of the application
    Given the user goes to the login page
    And the user sets the correct credentials
    When the user logs out
    Then the login page should be displayed
