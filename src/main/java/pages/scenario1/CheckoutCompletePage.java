package pages.scenario1;

import org.openqa.selenium.By;
import pages.BasePage;

public class CheckoutCompletePage extends BasePage {
    private By completeMessageLocator = By.cssSelector(".complete-header");

    public String getCompleteMessage() {
        return getText(completeMessageLocator);
    }
}
