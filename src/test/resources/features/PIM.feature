@PIMTest
Feature: PIM

  Background: the user is logged in
    Given the user goes to the login page
    When the user sets the correct credentials
    Then the user should be logged in the application

  Scenario: the user navigates to the PIM page using the side menu
    When the user navigates to the "PIM" page
    Then the "PIM" page should be displayed

  @deleteEmployee
  Scenario: the user adds a new employee
    When the user navigates to the "PIM" page
    And the user adds an employee with the information
      | firstName | middleName | lastName |
      | AddTest   | Alejandra  | Lopez    |
    Then a toast message with the text "Successfully Saved" is displayed
    And the employee is displayed in the employee list

  @deleteEmployee
  Scenario: the user can filter an employee by ID
    And the user adds an employee with the information
      | firstName  | middleName | lastName |
      | FilterTest | Alejandra  | Lopez    |
    When the user filters the new employee by its id
    Then the employee is displayed in the employee list

  Scenario: the user can delete an employee
    And the user adds an employee with the information
      | firstName  | middleName | lastName |
      | DeleteTest | Alejandra  | Lopez    |
    When the user deletes the employee
    Then a toast message with the text "Successfully Deleted" is displayed

  Scenario: the user navigates to the Reports tabs
    When the user navigates to the "Reports" tab
    Then the reports page should be displayed

  @deleteReport
  Scenario: the user adds a new report
    When the user navigates to the "Reports" tab
    And the user adds an report with the information
      | reportName     | displayFieldGroup | displayField |
      | TestReportName | Personal          | Nationality  |
    And the user saves the report
    Then a toast message with the text "Successfully Saved" is displayed

  @deleteReport
  Scenario: the user can filter a report by name
    When the user navigates to the "Reports" tab
    And the user adds an report with the information
      | reportName     | displayFieldGroup | displayField |
      | TestReportName | Personal          | Nationality  |
    And the user saves the report
    And the user filters the new report by the name "TestReportName"

  Scenario: the user deletes a new report
    When the user navigates to the "Reports" tab
    And the user adds an report with the information
      | reportName     | displayFieldGroup | displayField |
      | TestReportName | Personal          | Nationality  |
    And the user saves the report
    Then the user deletes the "TestReportName" report
