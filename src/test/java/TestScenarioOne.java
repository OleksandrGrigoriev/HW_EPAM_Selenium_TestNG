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

public class TestScenarioOne {

    private WebDriver driver;
    protected BasePage basePage;
    protected SauceDemoHomePage homePage;
    protected InventoryPage inventoryPage;
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
    public void enteringInventoryPageTest() {
        homePage = new SauceDemoHomePage();
        inventoryPage = homePage.clickRegisterButtonWithCorrectData();
        Assert.assertEquals("Swag Labs", inventoryPage.findLogoTitle());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
