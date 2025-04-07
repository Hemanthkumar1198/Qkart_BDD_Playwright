package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import locators.Locators;

public class Homepage extends BasePage {

	public Homepage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}

	public boolean verifyHomepageNavigation() {
		Locator headingLocator = page.locator(Locators.HOMEPAGE_HEADING_LOCATOR);
		headingLocator.waitFor();
		return headingLocator.isVisible();
	}

	public void ClickRegisterbutton() {
		page.waitForSelector(Locators.HP_REGISTER_BUTTON).click();
	}

	public void searchProduct(String searchProduct) {
		Locator searchLocator = page.locator(Locators.SEARCH_BUTTON);
		searchLocator.waitFor();
		searchLocator.fill(searchProduct);
	}

//	public void addToCart(String productName) {
//		Locator items = page.locator(Locators.PRODUCT_LIST);
//		items.waitFor();
//		int count = items.count();
//		for (int i = 0; i < count; i++) {
//			Locator item = items.nth(i);
//			if (item.innerText().contains(productName)) {
//				item.locator(Locators.PRODUCT_SELECTION).click();
//				System.out.println(productName + " added to cart!");
//				break;
//			}
//		}
//	}
	
	public void addToCart(String productName) {
		page.waitForSelector("//p[@class='MuiTypography-root MuiTypography-body1 css-yg30e6']");
        Locator items = page.locator("//p[@class='MuiTypography-root MuiTypography-body1 css-yg30e6']");
        for (int i = 0; i < items.count(); i++) {
            if (items.nth(i).innerText().contains("Roadster Mens Running Shoes")) {
                items.nth(i).locator("xpath=./ancestor::div[contains(@class,'MuiCard-root')]//button[text()='Add to cart']").click();
                System.out.println("Roadster Mens Running Shoes added to cart!");
                break;
            }
        }
	}

	public boolean verifyProductAddedToCart() {
		Locator cartProductLocator = page.locator(Locators.VERIFY_CART_PRODUCT_NAME);
		cartProductLocator.waitFor();
		return cartProductLocator.innerText().contains("Roadster Mens Running Shoes");
	}

	public void clickCheckoutButton() {
		Locator checkoutLocator = page.locator(Locators.CHECKOUT_BUTTON);
		checkoutLocator.waitFor();
		checkoutLocator.click();
	}

}
