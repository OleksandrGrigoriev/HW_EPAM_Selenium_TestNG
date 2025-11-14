import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.scenario1.*;

public class TestScenarioThree extends BaseTest{

    SoftAssert softAssert = new SoftAssert();
    protected final String AUT_URL = "https://www.saucedemo.com/";
    private static final int ITEMS_TO_CART = 4;
    protected SauceDemoHomePage homePage;
    protected InventoryPage inventoryPage;
    protected ShoppingCartPage shoppingCartPage;
    protected CheckoutPage checkoutPage;
    protected CheckoutOverViewPage checkoutOverViewPage;


    @BeforeMethod
    public void loadApplication() {
        driver.get(AUT_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
    }

    @Test
    public void sauceDemoSitePagesTest() throws InterruptedException {
        homePage = new SauceDemoHomePage();
        Thread.sleep(2000);
        inventoryPage = homePage.clickRegisterButtonWithCorrectData();
        inventoryPage.addItemsToCart(ITEMS_TO_CART);
        shoppingCartPage = inventoryPage.goToShoppingCart();
        Thread.sleep(2000);
        checkoutPage = shoppingCartPage.goToCheckoutPage();
        checkoutPage.enterCheckoutInfo();
        Thread.sleep(2000);
        checkoutOverViewPage = checkoutPage.goToCheckoutOverViewPge();
        Thread.sleep(2000);
        double finalPrice = checkoutOverViewPage.getFinalPrice();
        Assert.assertEquals(finalPrice, InventoryPage.orderPrice);
    }
}
