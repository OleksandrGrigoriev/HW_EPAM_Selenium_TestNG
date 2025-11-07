import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestScenario1 {

    private WebDriver driver;
    protected BasePage basePage;
    private final String AUT_URL = "https://www.amazon.com/";

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
    public void findSignInButtonOnBasePageTest() {
        basePage.refresh(driver);
        String textOfButton = basePage.findSignInButton().getText();
        Assert.assertEquals(textOfButton, "Sign in");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
