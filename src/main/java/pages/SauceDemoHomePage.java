package pages;

import org.openqa.selenium.By;

public class SauceDemoHomePage extends BasePage {

    private By usernameField = By.cssSelector("#user-name");
    private By passwordField = By.cssSelector("#password");
    private By buttonSelector = By.cssSelector(".submit-button");

    private String USER_NAME = "standard_user";
    private String PASSWORD = "secret_sauce";

    public InventoryPage clickRegisterButtonWithCorrectData() {
        find(usernameField).sendKeys(USER_NAME);
        find(passwordField).sendKeys(PASSWORD);
        click(buttonSelector);
        return new InventoryPage();
    }
}
