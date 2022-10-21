package pages.Admin;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class AddNationalityPage extends BasePage {
    public AddNationalityPage(WebDriver driver) {
        super(driver);
    }

    public void setNameTextBox(String value) {
        setTextBox("Name", value);
    }

    public void addNationality(String nationalityName) {
        clickOnAddBtn();
        setNameTextBox(nationalityName);
        clickOnSaveBtn();
    }
}
