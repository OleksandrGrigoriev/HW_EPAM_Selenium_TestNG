package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage extends BasePage{
    private By logoTitle = By.cssSelector(".app_logo");
    private List<WebElement> itemOnPage = driver.findElements(By.cssSelector(".btn_inventory"));
    private By cartButton = By.cssSelector(".shopping_cart_link");

    public String findLogoTitle() {
        return find(logoTitle).getText();
    }

    public void addItemsToCart() {
        itemOnPage.get(2).click();
        itemOnPage.get(3).click();
    }

    public ShoppingCartPage goToShoppingCart() {
        click(cartButton);
        return new ShoppingCartPage();
    }
}
