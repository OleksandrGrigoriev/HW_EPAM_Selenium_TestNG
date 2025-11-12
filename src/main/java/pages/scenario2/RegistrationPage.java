package pages.scenario2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class RegistrationPage extends BasePage {

    @FindBy(how = How.CSS, using = "#customer\\.firstName")
    public WebElement firstnameForm;

    @FindBy(how = How.CSS, using = "#customer\\.lastName")
    public WebElement lastnameForm;

    @FindBy(how = How.CSS, using = "#customer\\.address\\.street")
    public WebElement addressForm;

    @FindBy(how = How.CSS, using = "#customer\\.address\\.city")
    public WebElement cityForm;

    @FindBy(how = How.CSS, using = "#customer\\.address\\.state")
    public WebElement stateForm;

    @FindBy(how = How.CSS, using = "#customer\\.address\\.zipCode")
    public WebElement zipcodeForm;

    @FindBy(how = How.CSS, using = "#customer\\.phoneNumber")
    public WebElement phoneForm;

    @FindBy(how = How.CSS, using = "#customer\\.ssn")
    public WebElement ssnForm;

    @FindBy(how = How.CSS, using = "#customer\\.username")
    public WebElement usernameForm;

    @FindBy(how = How.CSS, using = "#customer\\.password")
    public WebElement passwordForm;

    @FindBy(how = How.CSS, using = "#repeatedPassword")
    public WebElement confirmationForm;

    @FindBy(how = How.XPATH, using = "//input[@value='Register']")
    public WebElement registerButton;

    private String firstName = "Alex";
    private String lastName = "Grigoriev";
    private String address = "Schevchenko str.";
    private String city = "Cherkasy";
    private String state = "Ukraine";
    private String zipCode = "18000";
    private String phone = "0937776655";
    private String ssn = "234";
    private String userName = "Alex";
    private String password = "1234567890";
    private String confirm = password;

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterRegistrationData() {
        firstnameForm.sendKeys(firstName);
        lastnameForm.sendKeys(lastName);
        addressForm.sendKeys(address);
        cityForm.sendKeys(city);
        stateForm.sendKeys(state);
        zipcodeForm.sendKeys(zipCode);
        phoneForm.sendKeys(phone);
        ssnForm.sendKeys(ssn);
        usernameForm.sendKeys(userName);
        passwordForm.sendKeys(password);
        confirmationForm.sendKeys(confirm);
    }

    public SuccessfulRegistrationPage register() {
        registerButton.click();
        return new SuccessfulRegistrationPage();
    }
}
