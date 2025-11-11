import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.util.HashMap;
import java.util.Map;

public class TestScenarioOne {
    SoftAssert softAssert = new SoftAssert();
    private final String AUT_URL = "https://www.saucedemo.com/";
    private static final int ITEMS_IN_CART = 2;
    private static final String COMPLETE_MESSAGE = "Thank you for your order!";
    private WebDriver driver;
    protected BasePage basePage;
    protected SauceDemoHomePage homePage;
    protected InventoryPage inventoryPage;
    protected ShoppingCartPage shoppingCartPage;
    protected CheckoutPage checkoutPage;
    protected CheckoutOverViewPage checkoutOverViewPage;
    protected CheckoutCompletePage checkoutCompletePage;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver(suppressWarning());
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(AUT_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
    }

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

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    private ChromeOptions suppressWarning() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("autofill.profile_enabled", false);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        return options;
    }
}
