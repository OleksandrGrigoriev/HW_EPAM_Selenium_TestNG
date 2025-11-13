import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.scenario1.*;

public class TestScenarioOne extends BaseTest{
    SoftAssert softAssert = new SoftAssert();
    private static final int ITEMS_IN_CART = 2;
    private static final String COMPLETE_MESSAGE = "Thank you for your order!";
    protected final String AUT_URL = "https://www.saucedemo.com/";
    protected SauceDemoHomePage homePage;
    protected InventoryPage inventoryPage;
    protected ShoppingCartPage shoppingCartPage;
    protected CheckoutPage checkoutPage;
    protected CheckoutOverViewPage checkoutOverViewPage;
    protected CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod
    public void loadApplication() {
        driver.get(AUT_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
    }

    @Test
    public void sauceDemoSitePagesTest() throws InterruptedException {
        homePage = new SauceDemoHomePage();
        Thread.sleep(3000);

        inventoryPage = homePage.clickRegisterButtonWithCorrectData();
        softAssert.assertEquals("Swag Labs", inventoryPage.findLogoTitle());
        inventoryPage.addItemsToCart();
        Thread.sleep(3000);

        shoppingCartPage = inventoryPage.goToShoppingCart();
        int amount = shoppingCartPage.getAmountOfItemsInShoppingCart();
        softAssert.assertEquals(ITEMS_IN_CART, amount);
        Thread.sleep(3000);

        checkoutPage = shoppingCartPage.goToCheckoutPage();
        checkoutPage.enterCheckoutInfo();
        Thread.sleep(3000);

        checkoutOverViewPage = checkoutPage.goToCheckoutOverViewPge();
        amount = checkoutOverViewPage.getAmountOfItemsOnCheckoutOverView();
        softAssert.assertEquals(ITEMS_IN_CART, amount);
        Thread.sleep(3000);

        checkoutCompletePage = checkoutOverViewPage.goToCheckoutCompletePage();
        String completeMessage = checkoutCompletePage.getCompleteMessage();
        softAssert.assertEquals(COMPLETE_MESSAGE, completeMessage);

    }
}
