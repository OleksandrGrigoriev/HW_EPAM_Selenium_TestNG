import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.scenario2.SuccessfulRegistrationPage;
import pages.scenario2.AccountsOverviewPage;
import pages.scenario2.ParaBankHomePage;
import pages.scenario2.RegistrationPage;

import java.util.List;

public class TestScenarioTwo extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    protected final String AUT_URL = "https://parabank.parasoft.com/parabank/index.htm";
    private final String REGISTRATION_SUCCESSFUL = "Welcome Alex";
    protected ParaBankHomePage homePage;
    protected AccountsOverviewPage accountsOverviewPage;
    protected RegistrationPage registrationPage;
    protected SuccessfulRegistrationPage successfulRegistrationPage;

    @BeforeMethod
    public void loadApplication() {
        driver.get(AUT_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
    }

    @Test
    public void paraBankSitePagesTest() throws InterruptedException {
        homePage = new ParaBankHomePage();
        homePage.enterRegistrationData();
        accountsOverviewPage = homePage.clickLogInButton();
        Thread.sleep(2000);

        // if registered account was deleted, we look for an Error message and register a new user
        List<WebElement> errorMessages = driver.findElements(By.cssSelector("#rightPanel > p"));

        if (!errorMessages.isEmpty()) {
            registrationPage = homePage.goToRegistrationPage();
            registrationPage.enterRegistrationData();
            Thread.sleep(3000);
            successfulRegistrationPage = registrationPage.register();
            Thread.sleep(3000);
            Assert.assertEquals(driver.findElement(By.cssSelector("h1.title")).getText(), REGISTRATION_SUCCESSFUL);
        }


    }
}
