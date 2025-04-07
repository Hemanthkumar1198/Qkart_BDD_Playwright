package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import locators.Locators;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class OrderCofirmationPage extends BasePage {

	public OrderCofirmationPage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}

	public void verifyOrderConfirmation(String orderplacedconfirmationText) {
		Locator confirmationMessage = page.locator(Locators.ORDER_PLACED_CONFIRMATION);
		confirmationMessage.waitFor();
		assertThat(confirmationMessage).containsText(orderplacedconfirmationText);
	}// Yay! It's o"rdered"

}
