package pages.PIM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class AddReportPage extends BasePage {
    public AddReportPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='oxd-form-row']//div[2]//div[2]//div[2]//button[1]")
    private WebElement addFieldButton;

    public WebElement getReportNameTextBox() {
        return getTextBox("Report Name");
    }

    public void setReportNameTextBox(String value) {
        setTextBox("Report Name", value);
    }

    public WebElement getSelectionCriteriaDropDown() {
        return getTextBox("Selection Criteria");
    }

    public void setSelectionCriteriaDropDown(String value) {
        setDropDownByText("Selection Criteria", value);
    }

    public WebElement getIncludeDropDown() {
        return getTextBox("Include");
    }

    public void setIncludeDropDown(String value) {
        setDropDownByText("Include", value);
    }

    public WebElement getSelectDisplayFieldGroupDropDown() {
        return getTextBox("Select Display Field Group");
    }

    public void setSelectDisplayFieldGroupDropDown(String value) {
        setDropDownByText("Select Display Field Group", value);
    }

    public WebElement getSelectDisplayFieldDropDown() {
        return getTextBox("Select Display Field");
    }

    public void setSelectDisplayFieldDropDown(String value) {
        setDropDownByText("Select Display Field", value);
    }

    public WebElement getAddFieldButton() {
        return addFieldButton;
    }

    public void clickAddFieldButton() {
        getAddFieldButton().click();
    }

    public void fillAddReportForm(String reportName, String displayFieldGroup, String displayField) {
        setReportNameTextBox(reportName);
        setSelectDisplayFieldGroupDropDown(displayFieldGroup);
        setSelectDisplayFieldDropDown(displayField);
    }
}
