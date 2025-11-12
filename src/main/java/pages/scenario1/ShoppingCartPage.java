package pages.scenario1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    private By cartItem = By.cssSelector(".cart_item");
    private List<WebElement> itemsInCart = driver.findElements(cartItem);
    private By checkoutButton = By.cssSelector(".checkout_button");

    public int getAmountOfItemsInShoppingCart() {
        return itemsInCart.size();
    }

    public CheckoutPage goToCheckoutPage() {
        click(checkoutButton);
        return new CheckoutPage();
    }
}
