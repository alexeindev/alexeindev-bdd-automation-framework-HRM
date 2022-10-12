Feature: Login

  Scenario: The user logs into the application
    Given the user goes to the login page
    When the user sets the correct credentials
    Then the "PIM" page should be displayed