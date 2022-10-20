package pages.PIM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

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

    public void senKeysToEmployeeIdTextBox(String value) {
        setTextBox("Employee Id", value);
    }

    public void clickOnDeleteEmployeeBtn() {
        getDeleteBtn().click();
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
}
