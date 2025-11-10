package pages;

import org.openqa.selenium.By;

public class InventoryPage extends BasePage{
    private By logoTitle = By.cssSelector(".app_logo");

    public String findLogoTitle() {
        return find(logoTitle).getText();
    }
}
