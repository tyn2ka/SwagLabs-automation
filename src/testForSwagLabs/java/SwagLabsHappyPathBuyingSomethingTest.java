import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesSwagLabs.SwagLabsOrder;
import pagesSwagLabs.SwagLabsHomePage;
import pagesSwagLabs.SwagLabsResults;

import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;


public class SwagLabsHappyPathBuyingSomethingTest extends BaseTest {
    private String login = "standard_user";
    private String password = "secret_sauce";
    private String firstName = "Anna";
    private String lastName = "Kolan";
    private String postalCode = "62-200";

    private final SwagLabsHomePage swagLabsHomePage = new SwagLabsHomePage();
    private final SwagLabsResults swagLabsResults = new SwagLabsResults();
    private final SwagLabsOrder swagLabsOrder = new SwagLabsOrder();


    @Test()
    public void buyingSomethingPath() {
        swagLabsHomePage.openSwagLabsPage();
        swagLabsHomePage.fillTextToUserNameFiled(login);
        swagLabsHomePage.fillTextToPassword(password);
        swagLabsHomePage.submitLoginButton();
        Assert.assertTrue(swagLabsResults.isAt(), "Result page not loaded");
        swagLabsOrder.submitAddToCardButton();
        Assert.assertTrue(swagLabsResults.isItemAddedToCart(), "Result page visible item");
        swagLabsOrder.clickBasketIcon();
        Assert.assertTrue(swagLabsResults.isOpenBasket(), "Result view not opened");
        swagLabsOrder.clickCheckOutButton();
        Assert.assertTrue(swagLabsResults.isOpenCheckOutInformation(), "Result view not opened");
        swagLabsOrder.fillFirstNameText(firstName);
        swagLabsOrder.fillLastNameText(lastName);
        swagLabsOrder.fillPostalCodeText(postalCode);
        swagLabsOrder.selectContinueButton();
        Assert.assertTrue(swagLabsResults.isOpenOverviewInformation(), "Result view not opened");
        swagLabsOrder.clickFinishButton();
        Assert.assertTrue(swagLabsResults.isOpenFinishView(), "Result view not opened");
    }

    // download all product list
    // choose random product from list
    // click "add tu cart" random product
    // open basket in shop
    // checking if proper random product is available

    @Test()
    public void buyingRandomProduct() {
        swagLabsHomePage.openSwagLabsPage();
        swagLabsHomePage.fillTextToUserNameFiled(login);
        swagLabsHomePage.fillTextToPassword(password);
        swagLabsHomePage.submitLoginButton();
        Assert.assertTrue(swagLabsResults.isAt(), "Result page not loaded");
        List<String> productItemsList = swagLabsOrder.getProductNameList();
        String randomProduct = productItemsList.get(new Random().nextInt(productItemsList.size()));
        swagLabsOrder.addProductToCart(randomProduct);
        swagLabsOrder.clickBasketIcon();
        List<String> shoppingCartItems = swagLabsOrder.getShoppingCartItemsList();
        assertEquals(shoppingCartItems.size(), 1, "Wrong shopping cart items list size");
        assertEquals(shoppingCartItems.get(0), randomProduct, randomProduct + " is not present in shopping cart. The item added is: " + shoppingCartItems.get(0));
        swagLabsOrder.clickCheckOutButton();
        swagLabsOrder.fillFirstNameText(firstName);
        swagLabsOrder.fillLastNameText(lastName);
        swagLabsOrder.fillPostalCodeText(postalCode);
        swagLabsOrder.selectContinueButton();
        Assert.assertTrue(swagLabsResults.isOpenOverviewInformation(), "Result view not opened");
        swagLabsOrder.clickFinishButton();
        Assert.assertTrue(swagLabsResults.isOpenFinishView(), "Result view not opened");
    }
}
