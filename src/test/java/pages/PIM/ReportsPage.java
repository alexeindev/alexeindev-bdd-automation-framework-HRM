package pages.PIM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ReportsPage extends BasePage {
    @FindBy(css = ".oxd-table-filter-title")
    private WebElement pageHeaderTitle;

    @FindBy(css = ".oxd-icon.bi-trash")
    private WebElement deleteBtn;

    public ReportsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDeleteBtn() {
        return deleteBtn;
    }

    public WebElement getPageHeaderTitle() {
        return pageHeaderTitle;
    }

    public void clickOnDeleteReportBtn() {
        getDeleteBtn().click();
    }

    public void setReportNameTextBox(String value) {
        setAutocompleteByText("Report Name", value);
    }

    public void filterReportByName(String reportName) {
        navigateWithTopBarMenu("Reports");
        setReportNameTextBox(reportName);
        clickOnSearchBtn();
    }

    public void deleteReport(String reportName) {
        filterReportByName(reportName);
        clickOnDeleteReportBtn();
        clickOnAcceptDeleteBtnFromModal();
    }

}
