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

    private String login = "Alex";
    private String password = "1234567890";

    public ParaBankHomePage() {
        PageFactory.initElements(driver, this);
    }

    public void enterCorrectRegistrationData() {
        usernameForm.sendKeys(login);
        passwordForm.sendKeys(password);
    }

    public ParaBankUserPAge clickLogInButton() {
        logInButton.click();
        return new ParaBankUserPAge();
    }
}
