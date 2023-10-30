package pagesSwagLabs;

import io.qameta.allure.Step;
import framework.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static framework.StepLogger.getLogger;
import static framework.WebDriverManager.getDriver;

public class SwagLabsHomePage extends BasePage {

    private static final By SELECTOR_USER_NAME_TEXT_WINDOW = By.cssSelector("input[id='user-name']");
    private static final By SELECTOR_PASSWORD = By.cssSelector("input[id='password']");
    private static final By SELECTOR_LOGIN_BUTTON =By.cssSelector("input[id='login-button']");
    private static final String URL = "https://www.saucedemo.com/v1/";

    @Step("Opening SwagLabs page")
    public void openSwagLabsPage(){
        getLogger().info("Opening SwagLabs page ");
        getDriver().get(URL);
    }

    @Step ("Entering user name filed: {text}")
    public void fillTextToUserNameFiled (String text){
        getLogger().info("Entering " + text + "into user name filed");
        getDriver().findElement(SELECTOR_USER_NAME_TEXT_WINDOW).sendKeys(text);
    }

    @Step ("Entering password filed: {text}")
    public void fillTextToPassword (String text){
        getLogger().info("Entering " + text + "into password filed");
        getDriver().findElement(SELECTOR_PASSWORD).sendKeys(text);
    }


    @Step ("Click login button")
    public void submitLoginButton(){
        getLogger().info("Select login button");
        getDriver().findElement(SELECTOR_LOGIN_BUTTON).submit();
    }


    @Override
    public boolean isAt() {
        getLogger().info("Checking if SwagLabs page is opened");
        return getTitle().equals("Product");
    }
}
