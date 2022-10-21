package pages.Admin;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class AddUserPage extends BasePage {
    public AddUserPage(WebDriver driver) {
        super(driver);
    }

    public void setUserRoleDropDown(String value) {
        setDropDownByText("User Role", value);
    }

    public void setStatusDropDown(String value) {
        setDropDownByText("Status", value);
    }

    public void setEmployeeNameAutocompleteTextBox(String value){
        setAutocompleteByTextWithoutSpaces("Employee Name", value);
    }

    public void setUsernameTextBox(String value){
        setTextBox("Username", value);
    }

    public void setPasswordTextBox(String value){
        setTextBox("Password", value);
    }

    public void setConfirmPasswordTextBox(String value){
        setTextBox("Confirm Password", value);
    }

    public void fillAddUsernameForm(String role, String name, String status, String username, String password) {
        setUserRoleDropDown(role);
        setEmployeeNameAutocompleteTextBox(name);
        setStatusDropDown(status);
        setUsernameTextBox(username);
        setPasswordTextBox(password);
        setConfirmPasswordTextBox(password);
    }

}
