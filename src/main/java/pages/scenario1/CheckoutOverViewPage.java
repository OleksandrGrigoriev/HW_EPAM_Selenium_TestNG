package pages.scenario1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class CheckoutOverViewPage extends BasePage {
    private final By cartItem = By.cssSelector(".cart_item");
    private final List<WebElement> itemsInCart = driver.findElements(cartItem);
    private final By finishButton = By.cssSelector("#finish");
    private final By finalPrice = By.xpath("//*[@class='summary_subtotal_label']");

    public int getAmountOfItemsOnCheckoutOverView() {
        return itemsInCart.size();
    }

    public double getFinalPrice() {
        return Double.parseDouble(driver.findElement(finalPrice).getText().substring(13));
    }

    public CheckoutCompletePage goToCheckoutCompletePage() {
        click(finishButton);
        return new CheckoutCompletePage();
    }
}
