package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    private static WebDriverWait wait;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addBtn;

    @FindBy(css = ".oxd-userdropdown-tab")
    private WebElement userDropDownBtn;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logOutBtn;

    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    private WebElement acceptDeleteBtn;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchBtn;

    @FindBy(css = ".oxd-brand-banner")
    private WebElement mainLogoImg;

    @FindBy(className = "oxd-topbar-header-breadcrumb-module")
    public WebElement titleBreadcrumb;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public WebElement getMainLogoImg() {
        return mainLogoImg;
    }

    private WebElement getSearchBtn() {
        return searchBtn;
    }

    public WebDriver getDriver() {
        return driver;
    }

    private WebElement getUserDropDownBtn() {
        return userDropDownBtn;
    }

    private WebElement getSaveBtn() {
        return saveBtn;
    }

    private WebElement getLogOutBtn() {
        return logOutBtn;
    }

    public WebElement getAcceptDeleteBtnFromModal() {
        return acceptDeleteBtn;
    }

    public WebElement getAddBtn() {
        return addBtn;
    }

    public void clickOnAddBtn() {
        getAddBtn().click();
    }

    public void clickOnSaveBtn() {
        getSaveBtn().click();
    }

    public void clickOnAcceptDeleteBtnFromModal() {
        getAcceptDeleteBtnFromModal().click();
    }

    public void clickOnUserDropDownBtn() {
        getUserDropDownBtn().click();
    }

    public void clickOnLogOutBtn() {
        getLogOutBtn().click();
    }

    public void clickOnSearchBtn() {
        getSearchBtn().click();
    }

    public void navigateWithSideMenu(String moduleName) {
        WebElement moduleElement = driver.findElement(By.xpath("//span[normalize-space()='%s']".formatted(moduleName)));
        moduleElement.click();
    }

    public void navigateWithTopBarMenu(String tabName) {
        WebElement moduleElement = driver.findElement(By.xpath("//*[@class='oxd-topbar-body-nav-tab-item' ][contains(text(),'%s')]".formatted(tabName)));
        moduleElement.click();
    }

    public boolean verifyBreadcrumbTitle(String breadcrumbTitle) {
        String currentTitle = titleBreadcrumb.getText();
        return breadcrumbTitle.equals(currentTitle);
    }

    public WebElement getToastMessage() throws NoSuchElementException {
        WebElement toastMessageElement = driver.findElement(By.className("oxd-text--toast-message"));
        wait.until(ExpectedConditions.visibilityOf(toastMessageElement));
        return toastMessageElement;
    }

    public WebElement getTextBox(String labelName) {
        return driver.findElement(By.xpath("//label[normalize-space()='%s']/../following-sibling::div/input".formatted(labelName)));
    }

    public void setTextBox(String labelName, String value) {
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
        autocompleteElement.sendKeys(optionToSelect.substring(0, 2));
        WebElement option = driver.findElement(By.xpath("//div[@role='option']/span[contains(text(),'%s')]".formatted(formattedOption)));
        option.click();
    }

}
