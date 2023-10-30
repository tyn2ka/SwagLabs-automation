package pagesSwagLabs;

import framework.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static framework.StepLogger.getLogger;

public class SwagLabsOrder extends BasePage {
    private static final By SELECTOR_ADD_TO_CARD = By.cssSelector("button[class='btn_primary btn_inventory']");
    private static final By SELECTOR_BASKET_ICON = By.cssSelector("div[id='shopping_cart_container']");
    private static final By SELECTOR_CHECKOUT_BUTTON = By.cssSelector("a[class='btn_action checkout_button']");
    private static final By SELECTOR_FIRST_NAME_FIELD = By.cssSelector("input[id='first-name']");
    private static final By SELECTOR_LAST_NAME_FILED = By.cssSelector("input[id='last-name']");
    private static final By SELECTOR_POSTAL_CODE_FILED = By.cssSelector("input[id='postal-code']");
    private static final By SELECTOR_FINISH_BUTTON = By.cssSelector("a[class='btn_action cart_button']");
    private static final By SELECTOR_CONTINUE_BUTTON = By.cssSelector("input[class='btn_primary cart_button']");

    @Step("Select 'Add to card' button")
    public void submitAddToCardButton() {
        By selectorAdd = By.cssSelector("button[class='btn_primary btn_inventory']");

        getLogger().info("Select 'Add to card' button");
        getDriver().findElement(SELECTOR_ADD_TO_CARD).click();
        getDriver();
    }

    @Step("Select 'Basket icon'")
    public void clickBasketIcon() {
        getLogger().info("Select 'basket icon'");
        getDriver().findElement(SELECTOR_BASKET_ICON).click();
    }

    @Step("Select 'Check out' button")
    public void clickCheckOutButton() {
        getLogger().info("Select 'Check out' button");
        getDriver().findElement(SELECTOR_CHECKOUT_BUTTON).click();
    }

    @Step()
    public void fillFirstNameText(String text) {
        getLogger().info("Entering " + text + "into 'First Name' filed");
        getDriver().findElement(SELECTOR_FIRST_NAME_FIELD).sendKeys(text);
    }

    @Step()
    public void fillLastNameText(String text) {
        getLogger().info("Entering " + text + "into 'Last Name' filed");
        getDriver().findElement(SELECTOR_LAST_NAME_FILED).sendKeys(text);
    }

    @Step()
    public void fillPostalCodeText(String text) {
        getLogger().info("Entering " + text + "into 'Postal Code' filed");
        getDriver().findElement(SELECTOR_POSTAL_CODE_FILED).sendKeys(text);
    }

    @Step()
    public void selectContinueButton() {
        getLogger().info("Select 'Continue' button");
        getDriver().findElement(SELECTOR_CONTINUE_BUTTON).click();
    }

    @Step("Select 'Check out' button")
    public void clickFinishButton() {
        getLogger().info("Select 'Finish' button");
        getDriver().findElement(SELECTOR_FINISH_BUTTON).click();
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
