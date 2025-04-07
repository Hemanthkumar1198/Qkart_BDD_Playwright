package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

import locators.Locators;

public class Checkoutpage extends BasePage {

	public Checkoutpage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}

	public void clickAddNewAddressButton() {
		page.waitForLoadState(LoadState.NETWORKIDLE);
		page.waitForSelector(Locators.ADD_NEW_ADDRESS_BUTTON).click();
	}

	public boolean isUserOnCheckoutPage() {
		page.waitForSelector(Locators.PLACE_ORDER_BUTTON);
		return page.locator(Locators.PLACE_ORDER_BUTTON).isVisible();
	}

	public void enterAddress(String address) {
		page.waitForSelector(Locators.ADDRESS_TEXT_FIELD).fill(address);
	}

	public void AddAddressbutton() {
		page.waitForSelector(Locators.ADD_ADDRESS_BUTTON).click();
	}

	public void selectAddress() {
		Locator locator =page.locator(Locators.SELECT_ADDRESS);
		locator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(5000));
		locator.scrollIntoViewIfNeeded();
		locator.click();
	}

	public void getPlaceOrderButton() {
		page.locator(Locators.PLACE_ORDER_BUTTON).click();

	}

}
