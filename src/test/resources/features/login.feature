Feature: Login

  Scenario: User should navigate to website
    Given the user goes to the login page
    When the user sets the correct credentials
    Then the user should be logged in the application