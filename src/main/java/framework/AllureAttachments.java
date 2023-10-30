package framework;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static framework.StepLogger.getLogger;

public final class AllureAttachments {

    private AllureAttachments() {}

    @Attachment("Failure screenshot")
    public static byte[] takeScreenshotOnFailure() {
        getLogger().info("Getting a screenshot on failure");
        WebDriver driver = WebDriverManager.getDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
