package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "username")
    public WebElement usernameTbx;

    @FindBy(name = "password")
    public WebElement passwordTbx;

    @FindBy(className = "orangehrm-login-button")
    public WebElement loginBtn;

    public void logUserIn(String username, String password) {
        usernameTbx.sendKeys(username);
        passwordTbx.sendKeys(password);
        loginBtn.click();
    }
}
