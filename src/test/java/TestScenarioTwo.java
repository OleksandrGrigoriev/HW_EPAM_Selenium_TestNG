import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.scenario2.ParaBankHomePage;
import pages.scenario2.ParaBankUserPage;
import pages.scenario2.RegistrationPage;

import java.util.List;

public class TestScenarioTwo extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    protected final String AUT_URL = "https://parabank.parasoft.com/parabank/index.htm";
    private final String REGISTRATION_SUCCESSFUL = "Welcome Alex";
    protected ParaBankHomePage homePage;
    protected ParaBankUserPage userPage;
    protected RegistrationPage registrationPage;

    @BeforeMethod
    public void loadApplication() {
        driver.get(AUT_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
    }

    @Test
    public void paraBankSitePagesTest() throws InterruptedException {
        homePage = new ParaBankHomePage();
        homePage.enterCorrectRegistrationData();
        userPage = homePage.clickLogInButton();
        Thread.sleep(3000);
        // if registered account was deleted
        List<WebElement> errorMessages = driver.findElements(By.cssSelector("#rightPanel > p"));
        if (!errorMessages.isEmpty()) {
            registrationPage = homePage.goToRegistrationPage();
            registrationPage.enterRegistrationData();
            Thread.sleep(3000);
            userPage = registrationPage.register();
            Thread.sleep(3000);
            softAssert.assertEquals(driver.findElement(By.cssSelector("h1.title")).getText(), REGISTRATION_SUCCESSFUL);
        }


    }
}
