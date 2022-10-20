package pages.PIM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class AddReportPage extends BasePage {
    @FindBy(xpath = "//div[@class='oxd-form-row']//div[2]//div[2]//div[2]//button[1]")
    private WebElement addFieldButton;

    public AddReportPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddFieldButton() {
        return addFieldButton;
    }

    public void clickAddFieldButton() {
        getAddFieldButton().click();
    }

    public void setReportNameTextBox(String value) {
        setTextBox("Report Name", value);
    }

    public void setSelectDisplayFieldGroupDropDown(String value) {
        setDropDownByText("Select Display Field Group", value);
    }

    public void setSelectDisplayFieldDropDown(String value) {
        setDropDownByText("Select Display Field", value);
    }

    public void fillAddReportForm(String reportName, String displayFieldGroup, String displayField) {
        setReportNameTextBox(reportName);
        setSelectDisplayFieldGroupDropDown(displayFieldGroup);
        setSelectDisplayFieldDropDown(displayField);
    }
}
