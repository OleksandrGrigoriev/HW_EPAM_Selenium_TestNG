import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.util.HashMap;
import java.util.Map;

public class TestScenarioOne extends BaseTest{
    SoftAssert softAssert = new SoftAssert();
    private static final int ITEMS_IN_CART = 2;
    private static final String COMPLETE_MESSAGE = "Thank you for your order!";
    protected InventoryPage inventoryPage;
    protected ShoppingCartPage shoppingCartPage;
    protected CheckoutPage checkoutPage;
    protected CheckoutOverViewPage checkoutOverViewPage;
    protected CheckoutCompletePage checkoutCompletePage;

    @Test
    public void sauceDemoSitePagesTest() {
        homePage = new SauceDemoHomePage();

        inventoryPage = homePage.clickRegisterButtonWithCorrectData();
        softAssert.assertEquals("Swag Labs", inventoryPage.findLogoTitle());
        inventoryPage.addItemsToCart();

        shoppingCartPage = inventoryPage.goToShoppingCart();
        int amount = shoppingCartPage.getAmountOfItemsInShoppingCart();
        softAssert.assertEquals(ITEMS_IN_CART, amount);

        checkoutPage = shoppingCartPage.goToCheckoutPage();
        checkoutPage.enterCheckoutInfo();

        checkoutOverViewPage = checkoutPage.goToCheckoutOverViewPge();
        amount = checkoutOverViewPage.getAmountOfItemsOnCheckoutOverView();
        softAssert.assertEquals(ITEMS_IN_CART, amount);

        checkoutCompletePage = checkoutOverViewPage.goToCheckoutCompletePage();
        String completeMessage = checkoutCompletePage.getCompleteMessage();
        softAssert.assertEquals(COMPLETE_MESSAGE, completeMessage);

    }
}
