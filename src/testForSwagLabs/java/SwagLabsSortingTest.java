import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesSwagLabs.SwagLabsSorting;
import pagesSwagLabs.SwagLabsHomePage;
import pagesSwagLabs.SwagLabsResults;

public class SwagLabsSortingTest extends BaseTest {
    private String login = "standard_user";
    private String password = "secret_sauce";

    private final SwagLabsHomePage swagLabsHomePage = new SwagLabsHomePage();
    private final SwagLabsResults swagLabsResults = new SwagLabsResults();
    private final SwagLabsSorting swagLabsSorting = new SwagLabsSorting();

    @Test()
    public void sortingFromAtoZ() {
        swagLabsHomePage.openSwagLabsPage();
        swagLabsHomePage.fillTextToUserNameFiled(login);
        swagLabsHomePage.fillTextToPassword(password);
        swagLabsHomePage.submitLoginButton();
        Assert.assertTrue(swagLabsResults.isAt(), "Result page not loaded");
        swagLabsSorting.filterFromAToZ();
        Assert.assertTrue(swagLabsResults.isFilterdFromAToZ(), "Lists are different");
    }

    @Test()
    public void sortingFromZtoA() {
        swagLabsHomePage.openSwagLabsPage();
        swagLabsHomePage.fillTextToUserNameFiled(login);
        swagLabsHomePage.fillTextToPassword(password);
        swagLabsHomePage.submitLoginButton();
        Assert.assertTrue(swagLabsResults.isAt(), "Result page not loaded");
        swagLabsSorting.sortingFromZToA();
        Assert.assertTrue(swagLabsResults.isAt());
        Assert.assertTrue(swagLabsResults.isFilterdFromZtoA(), "Lists are different");

    }

    @Test()
    public void sortingPriceLowToHigh() {
        swagLabsHomePage.openSwagLabsPage();
        swagLabsHomePage.fillTextToUserNameFiled(login);
        swagLabsHomePage.fillTextToPassword(password);
        swagLabsHomePage.submitLoginButton();
        Assert.assertTrue(swagLabsResults.isAt(), "Result page not loaded");
        swagLabsSorting.sortingPriceLowToHigh();
        Assert.assertTrue(swagLabsResults.isFilteredLowToHighPrice(), "Lists are different");
    }

    @Test()
    public void sortingPriceHighToLow() {
        swagLabsHomePage.openSwagLabsPage();
        swagLabsHomePage.fillTextToUserNameFiled(login);
        swagLabsHomePage.fillTextToPassword(password);
        swagLabsHomePage.submitLoginButton();
        Assert.assertTrue(swagLabsResults.isAt(), "Result page not loaded");
        swagLabsSorting.sortingPriceHighToLow();
        Assert.assertTrue(swagLabsResults.isAt());
        Assert.assertTrue(swagLabsResults.isFilteredHighToLowPrice(), "Lists are different");

    }
}
