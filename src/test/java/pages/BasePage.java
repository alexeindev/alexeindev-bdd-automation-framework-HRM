package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    public void navigateWithSideMenu(String moduleName) {
        WebElement moduleElement = driver.findElement(By.xpath("//span[normalize-space()='%s']".formatted(moduleName)));
        moduleElement.click();
    }

    @FindBy(className = "oxd-topbar-header-breadcrumb-module")
    public WebElement titleBreadcrumb;

    public boolean verifyBreadcrumbTitle(String breadcrumbTitle) {
        String currentTitle = titleBreadcrumb.getText();
        return breadcrumbTitle.equals(currentTitle);
    }

    public WebElement getTbxInputElement(String labelName) {
        return driver.findElement(By.xpath("//label[normalize-space()='%s']/../following-sibling::div/input".formatted(labelName)));
    }

    public void sendKeysToTextBox(String labelName, String value) {
        driver.findElement(By.xpath("//label[normalize-space()='%s']/../following-sibling::div/input".formatted(labelName))).sendKeys(value);
    }

    public void setDropDownByText(String labelName, String optionToSelect) {
        WebElement dropdownElement = driver.findElement(By.xpath("//label[normalize-space()='%s']/../following-sibling::div".formatted(labelName)));
        dropdownElement.click();
        WebElement option = driver.findElement(By.xpath("//div[@role='option']/span[contains(text(),'%s')]".formatted(optionToSelect)));
        option.click();
    }

    public void setAutocompleteByText(String labelName, String optionToSelect) {
        WebElement autocompleteElement = driver.findElement(By.xpath("//label[normalize-space()='%s']/../following-sibling::div/div/div/input".formatted(labelName)));
        String[] slicedString = optionToSelect.split(" ");
        String formattedOption = String.join("  ", slicedString);
        autocompleteElement.sendKeys(optionToSelect.substring(0,2));
        WebElement option = driver.findElement(By.xpath("//div[@role='option']/span[contains(text(),'%s')]".formatted(formattedOption)));
        option.click();
    }

    public class Field {

        private String fieldName;
        private String fieldType;
        private String value;

        public Field(String fieldName, String fieldType, String value) {
            this.fieldName = fieldName;
            this.fieldType = fieldType;
            this.value = value;
        }
    }
}
