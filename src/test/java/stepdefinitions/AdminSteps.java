package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Admin.AddUserPage;
import pages.Admin.AddNationalityPage;
import pages.Admin.NationalitiesPage;
import pages.Admin.UserManagementPage;

import java.util.List;
import java.util.Map;

import static stepdefinitions.Hooks.driver;
import static utilities.utilities.adminTabNames;
import static stepdefinitions.PimSteps.employeeId;


public class AdminSteps {

    private final AddNationalityPage addNationalityPage = new AddNationalityPage(driver);
    private final NationalitiesPage nationalitiesPage = new NationalitiesPage(driver);
    private final UserManagementPage userManagementPage = new UserManagementPage(driver);
    private final AddUserPage addUserPage = new AddUserPage(driver);

    public static String nationalityName = null;
    @Then("the Nationalities page should be displayed")
    public void theNationalitiesPageShouldBeDisplayed() {
        Assert.assertEquals(nationalitiesPage.getPageHeaderTitle().getText(), adminTabNames.NATIONALITIES.label);
    }

    @When("the user adds a nationality with the name {string}")
    public void theUserAddsANationalityWithTheName(String newNationalityName) {
        nationalityName = newNationalityName;
        addNationalityPage.addNationality(newNationalityName);
    }

    @When("the user creates a system user with the information")
    public void theUserCreatesASystemUserWithTheInformation(DataTable dataTable) {
        userManagementPage.clickOnAddBtn();
        List<Map<String, String>> signUpForms = dataTable.asMaps(String.class, String.class);
        String userRole = signUpForms.get(0).get("userRole");
        String employeeName = signUpForms.get(0).get("employeeName");
        String status = signUpForms.get(0).get("status");
        String userName = signUpForms.get(0).get("userName") + employeeId;
        String password = signUpForms.get(0).get("password");
        addUserPage.fillAddUsernameForm(userRole, employeeName, status, userName ,password);
        addUserPage.clickOnSaveBtn();
    }

    @When("the user deletes the nationality")
    public void theUserDeletesTheNationality() {
        nationalitiesPage.deleteNationality(nationalityName);
    }
}
