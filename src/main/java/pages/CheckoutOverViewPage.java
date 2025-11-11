package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutOverViewPage extends BasePage {
    private By cartItem = By.cssSelector(".cart_item");
    private List<WebElement> itemsInCart = driver.findElements(cartItem);
    private By finishButton = By.cssSelector("#finish");

    public int getAmountOfItemsOnCheckoutOverView() {
        return itemsInCart.size();
    }

    public CheckoutCompletePage goToCheckoutCompletePage() {
        click(finishButton);
        return new CheckoutCompletePage();
    }
}
