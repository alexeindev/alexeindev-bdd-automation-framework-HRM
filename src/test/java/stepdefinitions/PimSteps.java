package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.PIM.AddEmployeePage;
import pages.BasePage;
import pages.PIM.EmployeeListPage;
import pages.PIM.ReportsPage;

import java.util.List;
import java.util.Map;

import static stepdefinitions.Hooks.driver;
import static utilities.utilities.moduleNames;


public class PimSteps {

    private final EmployeeListPage employeeListPage = new EmployeeListPage(driver);
    private final AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
    private final ReportsPage reportsPage = new ReportsPage(driver);
    private final BasePage basePage = new BasePage(driver);
    public static String employeeId = null;
    public static String employeeName = null;


    @Given("the user clicks on the Add button of the PIM page")
    public void theUserClicksOnTheAddButtonOfThePIMPage() {
        employeeListPage.clickOnAddBtn();
    }

    @When("the user adds an employee with the information")
    public void theUserAddsAnEmployeeWithTheInformation(DataTable dataTable) {
        employeeListPage.clickOnAddBtn();
        List<Map<String, String>> signUpForms = dataTable.asMaps(String.class, String.class);
        String firstName = signUpForms.get(0).get("firstName");
        String middleName = signUpForms.get(0).get("middleName");
        String lastName = signUpForms.get(0).get("lastName");
        employeeName = firstName + middleName + lastName;
        employeeId = addEmployeePage.getEmployeeIdTextBoxValue();
        addEmployeePage.fillAddEmployeeForm(firstName, middleName, lastName);
        addEmployeePage.clickOnSaveBtn();
    }

    @When("the user deletes the employee")
    public void theUserDeletesTheEmployee() {
        employeeListPage.deleteEmployee(employeeId);
    }

    @When("the user navigates to the {string} tab")
    public void theUserNavigatesToTheTab(String tabName) {
        employeeListPage.navigateWithTopBarMenu(tabName);
    }

    @Then("the reports page should be displayed")
    public void theReportsPageShouldBeDisplayed() {
        Assert.assertEquals(reportsPage.getPageHeaderTitle().getText(), "Employee Reports");
    }

    @And("the employee is displayed in the employee list")
    public void theEmployeeIsDisplayedInTheEmployeeList() {
        basePage.navigateWithSideMenu(moduleNames.PIM.label);
        employeeListPage.filterEmployeeById(employeeId);
    }

    @And("the user filters the new employee by its id")
    public void theUserFiltersTheNewEmployeeByItsId() {
        basePage.navigateWithSideMenu(moduleNames.PIM.label);
        employeeListPage.filterEmployeeById(employeeId);
    }

    @When("the user filters the new employee by name")
    public void theUserFiltersTheNewEmployeeByName() {
        employeeListPage.filterEmployeeByName(employeeName);
    }
}
