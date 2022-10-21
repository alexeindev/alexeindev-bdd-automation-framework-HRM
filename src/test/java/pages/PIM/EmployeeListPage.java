package pages.PIM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import utilities.utilities.moduleNames;
public class EmployeeListPage extends BasePage {

    @FindBy(css = ".oxd-icon.bi-trash")
    private WebElement deleteBtn;

    @FindBy(css = ".oxd-icon.bi-pencil-fill")
    private WebElement editEmployeeBtn;

    public EmployeeListPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDeleteBtn() {
        return deleteBtn;
    }

    public void setEmployeeIdTextBox(String value) {
        setTextBox("Employee Id", value);
    }

    public void setEmployeeNameAutocompleteTextBox(String value) {
        setAutocompleteByText("Employee Name",value);
    }

    public void clickOnDeleteEmployeeBtn() {
        getDeleteBtn().click();
    }

    public void filterEmployeeById(String employeeId) {
        navigateWithSideMenu(moduleNames.PIM.label);
        setEmployeeIdTextBox(employeeId);
        clickOnSearchBtn();
    }

    public void filterEmployeeByName(String employeeName) {
        navigateWithSideMenu(moduleNames.PIM.label);
        setEmployeeNameAutocompleteTextBox(employeeName);
        clickOnSearchBtn();
    }

    public void deleteEmployee(String employeeId) {
        navigateWithSideMenu(moduleNames.PIM.label);
        filterEmployeeById(employeeId);
        clickOnDeleteEmployeeBtn();
        clickOnAcceptDeleteBtnFromModal();
    }

    public void deleteFilteredEmployee() {
        clickOnDeleteEmployeeBtn();
        clickOnAcceptDeleteBtnFromModal();
    }
}
