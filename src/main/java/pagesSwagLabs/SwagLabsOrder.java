package pagesSwagLabs;

import framework.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

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
    private static final By SELECTOR_PRODUCT_NAME = By.cssSelector("div[class='inventory_item_name']");
    private static final By SELECTOR_CART_ITEM_NAME = By.cssSelector("div[class='inventory_item_name']");


    @Step("Select 'Add to card' button")
    public void submitAddToCardButton() {
        getLogger().info("Select 'Add to card' button");
        getDriver().findElement(SELECTOR_ADD_TO_CARD).click();
    }

    @Step("Get Product Name list")
    public List<String> getProductNameList() {
        getLogger().info("Get Product Name list");
        return getDriver().findElements(SELECTOR_PRODUCT_NAME).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Add {product} to cart")
    public void addProductToCart(String product) {
        getLogger().info("Add " + product + " to cart");
        By selectorAddToCart = By.xpath("//div[text()='" + product + "']/ancestor::div[@class='inventory_item']//button");
        getDriver().findElement(selectorAddToCart).click();
    }

    @Step("Select 'Basket icon'")
    public void clickBasketIcon() {
        getLogger().info("Select 'basket icon'");
        getDriver().findElement(SELECTOR_BASKET_ICON).click();
    }

    @Step("Get Items in shopping cart")
    public List<String> getShoppingCartItemsList() {
        getLogger().info("Get items added to Shopping Cart");
        return getDriver().findElements(SELECTOR_CART_ITEM_NAME).stream().map(WebElement::getText).collect(Collectors.toList());
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

