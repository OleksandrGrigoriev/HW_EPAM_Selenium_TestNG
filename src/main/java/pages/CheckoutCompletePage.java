package pages;

import org.openqa.selenium.By;

public class CheckoutCompletePage extends BasePage {
    private By completeMessageLocator = By.cssSelector(".complete-header");

    public String getCompleteMessage() {
        return getText(completeMessageLocator);
    }
}
