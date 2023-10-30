package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Objects;

public class WebDriverManager {

    private static final String BROWSER = System.getProperty("browser", "chrome");

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    private WebDriverManager() {}

    public static WebDriver getDriver() {
        if (Objects.isNull(drivers.get())) {
            drivers.set(createDriver());
        }

        return drivers.get();
    }

    public static void quitDriver() {
        getDriver().close();
        drivers.set(null);
    }

    private static WebDriver createDriver() {
        switch (BROWSER.toLowerCase()) {
        case "firefox": return new FirefoxDriver();
       // case "chrome": return new ChromeDriver();
        default: StepLogger.getLogger().warn("Warning! No driver found for " + BROWSER + ". Falling back to chrome");
        return new FirefoxDriver();
        }
    }
}
