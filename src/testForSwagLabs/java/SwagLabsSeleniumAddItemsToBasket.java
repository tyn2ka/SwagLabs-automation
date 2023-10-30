import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesSwagLabs.SwagLabsOrder;
import pagesSwagLabs.SwagLabsHomePage;
import pagesSwagLabs.SwagLabsResults;

public class SwagLabsSeleniumAddItemsToBasket extends BaseTest {
    private String login = "standard_user";
    private String password = "secret_sauce";


    private final SwagLabsHomePage swagLabsHomePage = new SwagLabsHomePage();
    private final SwagLabsResults swagLabsResults = new SwagLabsResults();
    private final SwagLabsOrder swagLabsOrder = new SwagLabsOrder();


//    @Test()
//    public void swagLabsLoginTestPass() {
//        swagLabsHomePage.openSwagLabsPage();
//        swagLabsHomePage.fillTextToUserNameFiled(login);
//        swagLabsHomePage.fillTextToPassword(password);
//        swagLabsHomePage.submitLoginButton();
//
//        Assert.assertTrue(swagLabsResults.isAt(), "Result page not loaded");
//    }
    @Test()
    public void swagLabsAddToCardTestPass(){
        swagLabsHomePage.openSwagLabsPage();
        swagLabsHomePage.fillTextToUserNameFiled(login);
        swagLabsHomePage.fillTextToPassword(password);
        swagLabsHomePage.submitLoginButton();
        Assert.assertTrue(swagLabsResults.isAt(), "Result page not loaded");
        swagLabsOrder.submitAddToCardButton();
        Assert.assertTrue(swagLabsResults.isItemAddedToCart(),"Result page visible item");
    }


}
