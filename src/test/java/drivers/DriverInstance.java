package drivers;

import drivers.strategies.Driver;
import drivers.strategies.DriverManager;
import org.openqa.selenium.WebDriver;

public class DriverInstance {
    private static DriverInstance instance = null;
    private static WebDriver driver;

    private DriverInstance(String browserName) {
        instantiate(browserName);
    }

    public WebDriver instantiate(String browserName) {
        Driver driver = DriverManager.selectDriver(browserName);
        DriverInstance.driver = driver.setDriver();
        DriverInstance.driver.manage().window().maximize();
        return DriverInstance.driver;
    }

    public static DriverInstance getInstance(String browserName) {
        if (instance == null) {
            instance = new DriverInstance(browserName);
        }
        return instance;
    }

    public static void closeInstance() {
        instance = null;
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
