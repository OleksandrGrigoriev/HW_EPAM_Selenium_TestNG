package pages.scenario2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class ParaBankHomePage extends BasePage  {

    @FindBy(how = How.CSS, using = "input[name='username']")
    public WebElement usernameForm;

    @FindBy(how = How.CSS, using = "input[name='password']")
    public WebElement passwordForm;

    @FindBy(how = How.CSS, using = "input[type='submit']")
    public WebElement logInButton;

    @FindBy(how = How.XPATH, using = "//a[text()='Register']")
    public WebElement registerLink;

    private String login = "Alex";
    private String password = "1234567890";

    public ParaBankHomePage() {
        PageFactory.initElements(driver, this);
    }

    public void enterRegistrationData() {
        usernameForm.sendKeys(login);
        passwordForm.sendKeys(password);
    }

    public RegistrationPage goToRegistrationPage() {
        registerLink.click();
        return new RegistrationPage();
    }

    public AccountsOverviewPage clickLogInButton() {
        logInButton.click();
        return new AccountsOverviewPage();
    }
}
