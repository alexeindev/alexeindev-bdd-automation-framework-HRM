package drivers.strategies;

public class DriverManager {
    public static Driver selectDriver(String browserName) {
        switch (browserName) {
            case "CHROME":
                return new Chrome();
            case "FIREFOX":
                return new Firefox();
            default:
                return null;
        }
    }
}
