package pagesSwagLabs;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import framework.BasePage;
import org.openqa.selenium.support.ui.Select;

import static framework.StepLogger.getLogger;


public class SwagLabsSorting extends BasePage {

    private static final By SELECTOR_MAIN_DROP_DOWN_EXPAND = By.cssSelector("select[class='product_sort_container']");


    @Step("Filter from A to Z by filtering drop down")
    public void filterFromAToZ() {
        getLogger().info("Filter from A to Z");
        Select dropDown = new Select(getDriver().findElement(SELECTOR_MAIN_DROP_DOWN_EXPAND));
        dropDown.selectByValue("az");
    }

    @Step("Sorting from Z to A by filtering drop down")
    public void sortingFromZToA() {
        getLogger().info("Sorting from Z to A");
        Select droDdown = new Select(getDriver().findElement(SELECTOR_MAIN_DROP_DOWN_EXPAND));
        droDdown.selectByValue("za");
    }

    @Step("Sorting 'Price'(low to high) by filtering drop down")
    public void sortingPriceLowToHigh() {
        getLogger().info("Sorting 'Price'(low to high)");
        Select dropDown = new Select(getDriver().findElement(SELECTOR_MAIN_DROP_DOWN_EXPAND));
        dropDown.selectByValue("lohi");
    }

    @Step("Sorting 'Price'(high to low) by filtering drop down")
    public void sortingPriceHighToLow() {
        getLogger().info("Sorting 'Price'(high to low)");
        Select dropDown = new Select(getDriver().findElement(SELECTOR_MAIN_DROP_DOWN_EXPAND));
        dropDown.selectByValue("hilo");
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
