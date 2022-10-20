package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

import static stepdefinitions.Hooks.driver;

public class LoginSteps {
    private final LoginPage loginPage = new LoginPage(driver);

    @Given("the user goes to the login page")
    public void theUserGoesToTheLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the user enters only the username")
    public void theUserEntersOnlyTheUsername() {
        loginPage.logUserIn(System.getenv("username"), "");
    }

    @When("the user enters only the password")
    public void theUserEntersOnlyThePassword() {
        loginPage.logUserIn("", System.getenv("password"));
    }

    @When("the user sets the correct credentials")
    public void theUserSetsTheCorrectCredentials() {
        loginPage.logUserIn(System.getenv("username"), System.getenv("password"));
    }

    @When("the user logs out")
    public void theUserLogsOut() {
        loginPage.clickOnUserDropDownBtn();
        loginPage.clickOnLogOutBtn();
    }

    @Then("the user should be logged in the application")
    public void theUserShouldBeLoggedInTheApplication() {
        Assert.assertTrue(loginPage.getMainLogoImg().isDisplayed());
    }

    @Then("the user should receive and invalid credential message")
    public void theUserShouldReceiveAndInvalidCredentialMessage() {
        Assert.assertTrue(loginPage.getInvalidCredentialsMessage().isDisplayed());
    }

    @Then("the user should receive and required field message")
    public void theUserShouldReceiveAndRequiredFieldMessage() {
        Assert.assertTrue(loginPage.getRequiredFieldMessage().isDisplayed());
    }

    @Then("the login page should be displayed")
    public void theLoginPageShouldBeDisplayed() {
        Assert.assertTrue(loginPage.getLoginPageTitle().isDisplayed());
    }

    @And("the user sets the wrong credentials")
    public void theUserSetsTheWrongCredentials() {
        loginPage.logUserIn("notAnUser", "1234");
    }
}
