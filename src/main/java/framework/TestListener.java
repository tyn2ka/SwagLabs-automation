package framework;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static framework.StepLogger.getLogger;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        getLogger().info(result.getName() + " test starting...");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getLogger().info(result.getName() + " test PASSED");
        printDuration(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        getLogger().info(result.getName() + " test FAILED");
        printDuration(result);
        AllureAttachments.takeScreenshotOnFailure();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getLogger().info(result.getName() + " test SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        getLogger().info(result.getName() + " test FAILED but within success percentage");
    }

    @Override
    public void onStart(ITestContext context) {
        getLogger().info("This is onStart method: " + context.getOutputDirectory());
    }

    @Override
    public void onFinish(ITestContext context) {
        getLogger().info("This is onFinish method PASSED tests count: " + context.getPassedTests().size());
        getLogger().info("This is onFinish method FAILED tests count: " + context.getFailedTests().size());
    }

    private void printDuration(ITestResult result) {
        getLogger().info("Duration: " + (result.getEndMillis() - result.getStartMillis()) + "ms.");
    }
}
