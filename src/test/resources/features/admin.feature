@login @AdminTest
Feature: Admin Test
  Background: the user navigates to the Admin page using the side menu
    Given the user navigates to the "Admin" page

  Scenario: the user navigates to the Admin page using the side menu
    When the user navigates to the "Admin" page
    Then the "Admin" page should be displayed

  Scenario: the user navigates to the Nationalities tabs
    When the user navigates to the "Nationalities" tab
    Then the Nationalities page should be displayed

  @deleteNationality
  Scenario: the user can add a nationality
    And the user navigates to the "Nationalities" tab
    When the user adds a nationality with the name "ANewNationality"
    Then a toast message with the text "Successfully Saved" is displayed

  Scenario: the user can delete a nationality
    Given the user navigates to the "Nationalities" tab
    And the user adds a nationality with the name "ANewNationality"
    When the user deletes the nationality
    Then a toast message with the text "Successfully Deleted" is displayed


  @deleteEmployee
  Scenario: the user can create a system user
    Given the user navigates to the "PIM" page
    And the user adds an employee with the information
      | firstName | middleName | lastName |
      | Alejandra | Maria      | Lopez    |
    And the user navigates to the "Admin" page
    When the user creates a system user with the information
      | userRole | employeeName          | status  | userName | password  |
      | ESS      | Alejandra Maria Lopez | Enabled | Alejandra.Lopez1   | Admin123. |
