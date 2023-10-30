package framework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public abstract class BaseTest {

    @AfterMethod
    public void closeBrowser() {
        WebDriverManager.quitDriver();
    }
}
