package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BasePage;
import pages.LoginPage;

import static stepdefinitions.Hooks.driver;


public class LoginSteps {
    BasePage basePage = new BasePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Given("the user goes to the login page")
    public void theUserGoesToTheLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the user sets the correct credentials")
    public void theUserSetsTheCorrectCredentials() {
        loginPage.logUserIn("Admin", "admin123");
    }

    @When("^the user navigates to the \"(.*)\" page$")
    public void theUserNavigatesToThePage(String pageName) {
        basePage.navigateWithSideMenu(pageName);
    }

    @Then("^the \"(.*)\" page should be displayed$")
    public void thePageShouldBeDisplayed(String pageName) {
        Assert.assertTrue(loginPage.verifyBreadcrumbTitle(pageName));
    }
}
