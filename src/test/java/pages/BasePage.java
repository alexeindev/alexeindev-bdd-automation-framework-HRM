package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
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

    @FindBy(className = "oxd-topbar-header-breadcrumb-module")
    public WebElement titleBreadcrumb;

    public boolean verifyBreadcrumbTitle(String breadcrumbTitle) {
       String currentTitle = titleBreadcrumb.getText();
       return breadcrumbTitle.equals(currentTitle);
    }

}
