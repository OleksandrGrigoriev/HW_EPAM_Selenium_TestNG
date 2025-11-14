package pages.scenario1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class InventoryPage extends BasePage {
    private final By logoTitle = By.cssSelector(".app_logo");
    private final List<WebElement> itemsOnPage = driver.findElements(By.cssSelector(".btn_inventory"));
    private final List<WebElement> itemsPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
    private final By cartButton = By.cssSelector(".shopping_cart_link");

    public static double orderPrice = 0;

    public String findLogoTitle() {
        return find(logoTitle).getText();
    }

    public void addItemsToCart(int itemsInCart) {
        for (int i = 0; i < itemsInCart; i++) {
            itemsOnPage.get(i).click();
            orderPrice += Double.parseDouble(itemsPrices.get(i).getText().substring(1));
        }
    }

    public ShoppingCartPage goToShoppingCart() {
        click(cartButton);
        return new ShoppingCartPage();
    }
}
