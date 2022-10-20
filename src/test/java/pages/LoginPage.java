package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = ".orangehrm-login-title")
    private WebElement loginPageTitle;

    @FindBy(name = "username")
    public WebElement usernameTbx;

    @FindBy(name = "password")
    public WebElement passwordTbx;

    @FindBy(className = "orangehrm-login-button")
    public WebElement loginBtn;

    @FindBy(css = ".oxd-text.oxd-text--p.oxd-alert-content-text")
    private WebElement invalidCredentialsMessage;

    @FindBy(css = ".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")
    public WebElement requiredFieldMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLoginPageTitle() {
        return loginPageTitle;
    }

    public WebElement getInvalidCredentialsMessage() {
        return invalidCredentialsMessage;
    }

    public WebElement getRequiredFieldMessage() {
        return requiredFieldMessage;
    }

    public void logUserIn(String username, String password) {
        usernameTbx.sendKeys(username);
        passwordTbx.sendKeys(password);
        loginBtn.click();
    }
}
