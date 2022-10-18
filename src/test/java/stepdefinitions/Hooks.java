package stepdefinitions;

import drivers.DriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.PIM.EmployeeListPage;
import pages.PIM.ReportsPage;

import java.util.concurrent.TimeUnit;
import static stepdefinitions.PimSteps.employeeId;
import static stepdefinitions.ReportSteps.reportName;
public class Hooks {
    public static WebDriver driver;

    @Before(order=0)
    public void initializeTest() {
        System.out.println("Start the browser and Clear the cookies");
        launchBrowser();
    }


    public void launchBrowser() {
        DriverInstance driverInstance = DriverInstance.getInstance("chrome".toUpperCase());
        driver = DriverInstance.getDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        DriverInstance.closeInstance();
    }

    @After(value = "@createUser", order = 1)
    public void loginAfterHook()
    {
        EmployeeListPage employeeListPage = new EmployeeListPage(driver);
        employeeListPage.deleteEmployee(employeeId);
        System.out.println("Tagged After Hook");
    }

    @After(value = "@deleteReport", order = 1)
    public void deleteReportHook()
    {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.deleteReport(reportName);
        System.out.println("Delete report hook");
    }

    @After(value = "@deleteEmployee", order = 1)
    public void deleteEmployeeHook()
    {
        EmployeeListPage employeeListPage = new EmployeeListPage(driver);
        employeeListPage.deleteEmployee(employeeId);
        System.out.println("Delete employee hook");
    }
    @After(order=0)
    public void finishTest() {
        closeBrowser();
    }

}
