package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BasePage;
import pages.LoginPage;

import static stepdefinitions.Hooks.driver;


public class LoginSteps {
    private BasePage basePage = new BasePage(driver);
    private LoginPage loginPage = new LoginPage(driver);

    @Given("the user goes to the login page")
    public void theUserGoesToTheLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the user sets the correct credentials")
    public void theUserSetsTheCorrectCredentials() {
        loginPage.logUserIn("Admin", "admin123");
    }

    @Then("the user should be logged in the application")
    public void theUserShouldBeLoggedInTheApplication() {
        Assert.assertTrue(loginPage.verifyBreadcrumbTitle("PIM"));
    }
}
