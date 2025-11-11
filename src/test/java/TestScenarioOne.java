import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.InventoryPage;
import pages.SauceDemoHomePage;
import pages.ShoppingCartPage;

public class TestScenarioOne {

    private static final int ITEMS_IN_CART = 2;
    private WebDriver driver;
    protected BasePage basePage;
    protected SauceDemoHomePage homePage;
    protected InventoryPage inventoryPage;
    protected ShoppingCartPage shoppingCartPage;
    private final String AUT_URL = "https://www.saucedemo.com/";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
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
        inventoryPage.addItemsToCart();
        shoppingCartPage = inventoryPage.goToShoppingCart();
        int amount = shoppingCartPage.getAmountOfItemsInShoppingCart();
        Assert.assertEquals(ITEMS_IN_CART, amount);
        //Assert.assertEquals("Swag Labs", inventoryPage.findLogoTitle());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
