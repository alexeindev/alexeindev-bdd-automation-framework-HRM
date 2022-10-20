package pages.PIM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class AddEmployeePage extends BasePage {
    @FindBy(name = "firstName")
    private WebElement firstNameTextBox;

    @FindBy(name = "middleName")
    private WebElement middleNameTextBox;

    @FindBy(name = "lastName")
    private WebElement lastNameTextBox;


    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstNameTextBox() {
        return firstNameTextBox;
    }

    public String getEmployeeIdTextBoxValue() {
        return getTextBox("Employee Id").getAttribute("value");
    }

    public WebElement getMiddleNameTextBox() {
        return middleNameTextBox;
    }

    public WebElement getLastNameTextBox() {
        return lastNameTextBox;
    }

    public void senKeysToFirstNameTextBox(String value) {
        getFirstNameTextBox().sendKeys(value);
    }

    public void sendKeysToMiddleNameTextBox(String value) {
        getMiddleNameTextBox().sendKeys(value);
    }

    public void sendKeysToLastNameTextBox(String value) {
        getLastNameTextBox().sendKeys(value);
    }

    public void fillAddEmployeeForm(String firstName, String middleName, String lastName) {
        senKeysToFirstNameTextBox(firstName);
        sendKeysToMiddleNameTextBox(middleName);
        sendKeysToLastNameTextBox(lastName);
    }
}
