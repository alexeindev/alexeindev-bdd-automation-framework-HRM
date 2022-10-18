package pages.PIM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class EmployeeListPage extends BasePage {
    public EmployeeListPage(WebDriver driver) {
        super(driver);
    }

    //Employee Information Form

    public void senKeysToEmployeeNameTextBox(String value) {
        setAutocompleteByText("Employee Name", value);
    }

    public void senKeysToSupervisorNameTextBox(String value) {
        setAutocompleteByText("Supervisor Name", value);
    }

    public void senKeysToEmployeeIdTextBox(String value) {
        setTextBox("Employee Id", value);
    }

    public void setEmploymentStatusDropDown(String value) {
        setTextBox("Employment Status", value);
    }

    public void setIncludeDropDown(String value) {
        setTextBox("Include", value);
    }

    public void setJobTitleDropDown(String value) {
        setTextBox("Job Title", value);
    }

    public void setSubUnitDropDown(String value) {
        setTextBox("Sub Unit", value);
    }

    //Card Filtered Elements
    @FindBy(css = "div[class*='orangehrm-vertical-padding'] span[class='oxd-text oxd-text--span']")
    private WebElement searchTittle;

    @FindBy(css = ".oxd-icon.bi-trash")
    private WebElement deleteBtn;

    public WebElement getDeleteBtn() {
        return deleteBtn;
    }

    public void clickOnDeleteEmployeeBtn() {
        getDeleteBtn().click();
    }

    @FindBy(xpath = "//span[normalize-space()='No Records Found']")
    private WebElement emptyMessageBtn;
    @FindBy(css = ".oxd-icon.bi-pencil-fill")
    private WebElement editEmployeeBtn;

    public WebElement getEditEmployeeBtn() {
        return editEmployeeBtn;
    }

    public void clickOnEditEmployeeBtn() {
        getEditEmployeeBtn().click();
    }

    public void filterEmployeeById(String employeeId) {
        navigateWithSideMenu("PIM");
        senKeysToEmployeeIdTextBox(employeeId);
        clickOnSearchBtn();
    }

    public void deleteEmployee(String employeeId) {
        navigateWithSideMenu("PIM");
        filterEmployeeById(employeeId);
        clickOnDeleteEmployeeBtn();
        clickOnAcceptDeleteBtnFromModal();
    }

    public void deleteFilteredEmployee() {
        clickOnDeleteEmployeeBtn();
        clickOnAcceptDeleteBtnFromModal();
    }

    public void editEmployee(String employeeId) {
        filterEmployeeById(employeeId);
        clickOnEditEmployeeBtn();
    }



}
