package stepdefinitions;

import drivers.DriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.Admin.NationalitiesPage;
import pages.LoginPage;
import pages.PIM.EmployeeListPage;
import pages.PIM.ReportsPage;

import java.time.Duration;

import static stepdefinitions.PimSteps.employeeId;
import static stepdefinitions.ReportSteps.reportName;
import static stepdefinitions.AdminSteps.nationalityName;

public class Hooks {
    public static WebDriver driver;

    @Before(order = 0)
    public void initializeTest() {
        launchBrowser();
    }

    @Before(value = "@login", order = 1)
    public void loginHook() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logUserIn(System.getenv("username"), System.getenv("password"));
    }

    @After(value = "@deleteReport", order = 1)
    public void deleteReportHook() {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.deleteReport(reportName);
    }

    @After(value = "@deleteEmployee", order = 1)
    public void deleteEmployeeHook() {
        EmployeeListPage employeeListPage = new EmployeeListPage(driver);
        employeeListPage.deleteEmployee(employeeId);
    }

    @After(value = "@deleteNationality", order = 1)
    public void deleteNationalityHook() {
        NationalitiesPage nationalitiesPage = new NationalitiesPage(driver);
        nationalitiesPage.deleteNationality(nationalityName);
    }

    @After(order = 0)
    public void finishTest() {
        closeBrowser();
    }

    public void launchBrowser() {
        DriverInstance.getInstance(System.getenv("browser").toUpperCase());
        driver = DriverInstance.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void closeBrowser() {
        DriverInstance.closeInstance();
    }

}
