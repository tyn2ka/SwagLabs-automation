package pagesSwagLabs;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;
import java.util.stream.Collectors;

import static framework.StepLogger.getLogger;

public class SwagLabsResults extends BasePage {
    private static final By SELECTOR_RESULTS = By.cssSelector("div[id='contents_wrapper']");

    private static final By SELECTOR_ERROR_MESSAGE = By.cssSelector("div[class='error-message-container error']");
    private static final By SELECTOR_ITEMS_LIST = By.cssSelector("div[class='inventory_item_name']");
    private static final By SELECTOR_ITEM_PRICE_LIST = By.cssSelector("div[class='inventory_item_price']");
    private static final By SELECTOR_RESULTS_FOR_BASKET = By.cssSelector("span[class='fa-layers-counter shopping_cart_badge']");
    private static final By SELECTOR_YOUR_CART_RESULT = By.cssSelector("div[class='subheader']");
    private static final By SELECTOR_FINISH_VIEW = By.cssSelector("img[class='pony_express']");

    @Override
    public boolean isAt() {
        getLogger().info("Checking if search result page is opened");
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(SELECTOR_RESULTS)).isDisplayed();
        //czekaj tak dlugo az element bedzie widoczny
    }

    public boolean isError() {
        getLogger().info("Checking if error message is visible");
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(SELECTOR_ERROR_MESSAGE)).isDisplayed();
    }

    public boolean isItemAddedToCart() {
        getLogger().info("Checking if item is in basket");
        return getDriver().findElement(SELECTOR_RESULTS_FOR_BASKET).getText().equals("1");
    }

    public boolean isOpenBasket() {
        getLogger().info("Checking if basket view is open");
        return getDriver().findElement(SELECTOR_YOUR_CART_RESULT).getText().equals("Your Cart");
    }

    public boolean isOpenCheckOutInformation() {
        getLogger().info("Checking if 'Checkout information' view is open");
        return getDriver().findElement(SELECTOR_YOUR_CART_RESULT).getText().equals("Checkout: Your Information");
    }

    public boolean isOpenOverviewInformation() {
        getLogger().info("Checking if 'Overview information' view is open");
        return getDriver().findElement(SELECTOR_YOUR_CART_RESULT).getText().equals("Checkout: Overview");
    }

    public boolean isOpenFinishView() {
        getLogger().info("Checking if 'Finish' view is open");
        return getDriver().findElement(SELECTOR_FINISH_VIEW).isDisplayed();
    }

    public boolean isFilterdFromAToZ() {
        getLogger().info("Checking if items are filtering");
        List<WebElement> itemsList = getDriver().findElements(SELECTOR_ITEMS_LIST);
        List<String> newItemsList = new ArrayList<>();

        for (WebElement element : itemsList) {
            String strItemsList = element.getText();
            newItemsList.add(strItemsList);
            System.out.println(strItemsList);
        }

        List<String> copynewItemList = new ArrayList<>(newItemsList);
        Collections.sort(copynewItemList);

        return newItemsList.equals(copynewItemList);
    }

    public boolean isFilterdFromZtoA() {
        getLogger().info("Checking if items are filtering");
        List<WebElement> itemsList = getDriver().findElements(SELECTOR_ITEMS_LIST);
        List<String> newItemsList = new ArrayList<>();

        for (WebElement element : itemsList) {
            String strItemsList = element.getText();
            newItemsList.add(strItemsList);
            System.out.println(strItemsList);
        }

        List<String> copyNewItemList = new ArrayList<>(newItemsList);
        Collections.sort(copyNewItemList, Comparator.reverseOrder());

        return newItemsList.equals(copyNewItemList);
    }

    public boolean isFilteredLowToHighPrice() {
        getLogger().info("Checking if items are filtering by price");
        List<WebElement> priceList = getDriver().findElements(SELECTOR_ITEM_PRICE_LIST);
        List<String> newPriceList = new ArrayList<>();

        for (WebElement priceElement : priceList) {
            String strPriceList = priceElement.getText();
            String removeLetter = strPriceList.replace("$", "");
            newPriceList.add((removeLetter));
            System.out.println(removeLetter);
        }
        List<Double> resultNewPriceList = newPriceList.stream().map(Double::parseDouble).collect(Collectors.toList());
        List<Double> copyNewPriceList = new ArrayList<>(resultNewPriceList);
        Collections.sort(copyNewPriceList);
        return resultNewPriceList.equals(copyNewPriceList);
    }

    public boolean isFilteredHighToLowPrice() {
        getLogger().info("Checking if items are filtering by price");
        List<WebElement> priceList = getDriver().findElements(SELECTOR_ITEM_PRICE_LIST);
        List<String> newPriceList = new ArrayList<>();

        for (WebElement priceElement : priceList) {
            String strPriceList = priceElement.getText();
            String removeLetter = strPriceList.replace("$", "");
            newPriceList.add((removeLetter));
            System.out.println(removeLetter);
        }
        List<Double> resultNewPriceList = newPriceList.stream().map(Double::parseDouble).collect(Collectors.toList());
        List<Double> copyNewPriceList = new ArrayList<>(resultNewPriceList);
        Collections.sort(copyNewPriceList, Collections.reverseOrder());
        System.out.println(copyNewPriceList);
        return resultNewPriceList.equals(copyNewPriceList);
    }
}