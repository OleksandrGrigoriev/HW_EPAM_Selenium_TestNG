import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.scenario2.ParaBankHomePage;
import pages.scenario2.ParaBankUserPAge;

public class TestScenarioTwo extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    protected final String AUT_URL = "https://parabank.parasoft.com/parabank/index.htm";
    protected ParaBankHomePage homePage;
    protected ParaBankUserPAge userPage;

    @BeforeMethod
    public void loadApplication() {
        driver.get(AUT_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
    }

    @Test
    public void sauceDemoSitePagesTest() throws InterruptedException {
        homePage = new ParaBankHomePage();
        homePage.enterCorrectRegistrationData();
        Thread.sleep(3000);
        userPage = homePage.clickLogInButton();
        Thread.sleep(3000);

    }
}
