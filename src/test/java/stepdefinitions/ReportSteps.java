package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.PIM.AddReportPage;
import pages.PIM.ReportsPage;

import java.util.List;
import java.util.Map;

import static stepdefinitions.Hooks.driver;
import static utilities.utilities.pimTabNames;



public class ReportSteps {

    private final ReportsPage reportsPage = new ReportsPage(driver);
    private final AddReportPage addReportPage = new AddReportPage(driver);

    public static String reportName = null;

    @When("the user filters the new report by the name {string}")
    public void theUserFiltersTheNewReportByItsName(String reportName) {
        reportsPage.navigateWithTopBarMenu(pimTabNames.REPORTS.label);
        reportsPage.setReportNameTextBox(reportName);
    }

    @And("the user adds an report with the information")
    public void theUserAddsAnReportWithTheInformation(DataTable dataTable) {
        addReportPage.clickOnAddBtn();
        List<Map<String, String>> signUpForms = dataTable.asMaps(String.class, String.class);
        String reportName = signUpForms.get(0).get("reportName");
        ReportSteps.reportName = reportName;
        String displayFieldGroup = signUpForms.get(0).get("displayFieldGroup");
        String displayField = signUpForms.get(0).get("displayField");
        addReportPage.fillAddReportForm(reportName, displayFieldGroup, displayField);
    }

    @And("the user sets {string} as the report name")
    public void theUserSetsAsTheReportName(String reportName) {
        addReportPage.setReportNameTextBox(reportName);
        ReportSteps.reportName = reportName;
    }

    @And("the user sets {string} as the display field group")
    public void theUserSetsAsTheDisplayFieldGroup(String displayFieldGroup) {
        addReportPage.setSelectDisplayFieldGroupDropDown(displayFieldGroup);
    }

    @And("the user sets {string} as the display field")
    public void theUserSetsAsTheDisplayField(String displayField) {
        addReportPage.setSelectDisplayFieldDropDown(displayField);
    }

    @And("the user saves the report")
    public void theUserSavesTheReport() {
        addReportPage.clickAddFieldButton();
        addReportPage.clickOnSaveBtn();
    }

    @And("the user deletes the {string} report")
    public void theUserDeletesTheReport(String reportName) {
        reportsPage.deleteReport(reportName);
    }
}
