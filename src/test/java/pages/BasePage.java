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
import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;
    private static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "oxd-topbar-header-breadcrumb-module")
    public WebElement titleBreadcrumb;


    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement resetBtn;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchBtn;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addBtn;

    public void clickOnResetBtn() {
        getResetBtn().click();
    }

    private WebElement getResetBtn() {
        return resetBtn;
    }

    public void clickOnSearchBtn() {
        getSearchBtn().click();
    }

    private WebElement getSearchBtn() {
        return searchBtn;
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

    public void navigateWithTopBarMenu(String tabName) {
        WebElement moduleElement = driver.findElement(By.xpath("//*[@class='oxd-topbar-body-nav-tab-item' ][contains(text(),'%s')]".formatted(tabName)));
        moduleElement.click();
    }

    public void clickOnSaveBtn() {
        getSaveBtn().click();
    }

    private WebElement getSaveBtn() {
        return saveBtn;
    }

    public void clickOnCancelBtn()  {
        getCancelBtn().click();
    }

    private WebElement getCancelBtn() {
        return cancelBtn;
    }

    public boolean verifyBreadcrumbTitle(String breadcrumbTitle) {
        String currentTitle = titleBreadcrumb.getText();
        return breadcrumbTitle.equals(currentTitle);
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

    public WebElement getToastMessage() throws NoSuchElementException {
        WebElement toastMessageElement = driver.findElement(By.className("oxd-text--toast-message"));
        wait.until(ExpectedConditions.visibilityOf(toastMessageElement));
        return toastMessageElement;
    }

    //Delete Modal

    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    private WebElement acceptDeleteBtn;

    public WebElement getAcceptDeleteBtnFromModal() {
        return acceptDeleteBtn;
    }

    public void clickOnAcceptDeleteBtnFromModal() {
        getAcceptDeleteBtnFromModal().click();
    }

    public WebElement getAddBtn() {
        return addBtn;
    }

    public void clickOnAddBtn() {
        getAddBtn().click();
    }

}
