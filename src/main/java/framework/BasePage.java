package framework;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    private static final long WAIT_TIME_SEC = 10L;

    @Step("Checking which page is opened")
    public abstract boolean isAt();

    @Step("Get page title")
    public final String getTitle() {
        return getDriver().getTitle();
    }

    protected final WebDriver getDriver() {
        return WebDriverManager.getDriver();
    }

    protected final WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_TIME_SEC));
    }
}
