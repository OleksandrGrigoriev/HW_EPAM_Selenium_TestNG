package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    private By cartItem = By.cssSelector(".cart_item");
    private List<WebElement> itemsInCart = driver.findElements(cartItem);

    public int getAmountOfItemsInShoppingCart() {
        return itemsInCart.size();
    }
}
