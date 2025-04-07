package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import locators.Locators;

public class Loginpage extends BasePage {

	public Loginpage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}

	public void loginUser(String username, String password) {
	    page.waitForSelector(Locators.USERNAME_INPUT);
	    page.fill(Locators.USERNAME_INPUT, username);
	    page.fill(Locators.PASSWORD_INPUT, password);
	}

	public void clickLoginButton() {
	    page.click(Locators.LOGIN_BUTTON);
	}

	public boolean verifyLoginPageNavigation() {
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page.url().endsWith("login");
	}

	public boolean verifyLoginsuccessfull() {
		page.waitForSelector("//button[text()='Logout']");
		return page.waitForSelector("//button[text()='Logout']").isVisible();
	}

}
