import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.BasePage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;
    protected BasePage basePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver(suppressWarning());
        driver.manage().window().maximize();
    }

//    @AfterMethod
//    public void takeScreenshotForFailures(ITestResult testResult) {
//        if(ITestResult.FAILURE == testResult.getStatus()) {
//            TakesScreenshot screenshot = (TakesScreenshot) driver;
//            File source = screenshot.getScreenshotAs(OutputType.FILE);
//            File destination = new File(System.getProperty("user.dir") +
//                    "/resources/screenshots/" +
//                    testResult.getName() + ".png");
//
//            try {
//                FileHandler.copy(source, destination);
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        }
//    }

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