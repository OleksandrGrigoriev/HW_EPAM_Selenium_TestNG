package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage {
    private String name = "Alex";
    private String lastName = "Grigoriev";
    private String index = "18000";

    private By nameForm = By.name("firstName");
    private By lastNameForm = By.cssSelector("#last-name");
    private By indexForm = By.cssSelector("#postal-code");
    private By continueButton = By.cssSelector("#continue");

    public void enterCheckoutInfo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Waits up to 10 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
        find(nameForm).sendKeys(name);
        find(lastNameForm).sendKeys(lastName);
        find(indexForm).sendKeys(index);
    }

    public CheckoutOverViewPage goToCheckoutOverViewPge() {
        click(continueButton);
        return new CheckoutOverViewPage();
    }
}
