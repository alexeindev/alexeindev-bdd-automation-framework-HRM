package stepdefinitions;

import drivers.DriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void initializeTest() {
        System.out.println("Start the browser and Clear the cookies");
        launchBrowser();
    }

    @After
    public void finishTest() {
        closeBrowser();
    }

    public void launchBrowser() {
        DriverInstance driverInstance = DriverInstance.getInstance("chrome".toUpperCase());
        driver = DriverInstance.getDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        DriverInstance.closeInstance();
    }
}
