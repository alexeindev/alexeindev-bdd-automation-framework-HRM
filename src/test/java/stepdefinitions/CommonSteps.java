package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.BasePage;
import pages.LoginPage;

import static stepdefinitions.Hooks.driver;

public class CommonSteps {
    private BasePage basePage = new BasePage(driver);
    private LoginPage loginPage = new LoginPage(driver);

    @Then("the {string} page should be displayed")
    public void thePageShouldBeDisplayed(String pageName) {
        Assert.assertTrue(loginPage.verifyBreadcrumbTitle(pageName));
    }

    @When("the user navigates to the {string} page")
    public void theUserNavigatesToThePage(String pageName) {
        basePage.navigateWithSideMenu(pageName);
    }

    @Then("a toast message with the text {string} is displayed")
    public void aToastMessageWithTheTextIsDisplayed(String toastMessageText) {
        WebElement toastMessageElement = basePage.getToastMessage();
        Assert.assertEquals(toastMessageElement.getText(), toastMessageText);
    }

    @And("the user clicks on the add button")
    public void theUserClicksOnTheAddButton() {
        basePage.clickOnAddBtn();
    }
}
