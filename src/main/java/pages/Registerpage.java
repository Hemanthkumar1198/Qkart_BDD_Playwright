package pages;

import java.text.SimpleDateFormat;
import java.util.UUID;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import locators.Locators;

public class Registerpage extends BasePage{

	public Registerpage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}
	
	public static String timestamp = new SimpleDateFormat("ddMMyyyyHHmmss").format(new java.util.Date());
	public static String email = "Tester_" + timestamp;
	public static String password = "Password" + UUID.randomUUID();
    
    public void getCredintials() {
    	System.out.println("Generated Credentials: ");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }
    
    public void registerUser() {
    	page.waitForLoadState(LoadState.NETWORKIDLE);
        page.waitForSelector(Locators.USERNAME_INPUT);
        page.fill(Locators.USERNAME_INPUT, email);
        page.fill(Locators.PASSWORD_INPUT, password);
        page.fill(Locators.CONFIRM_PASSWORD_INPUT, password);
        System.out.println("Credentials filled.");
    }

    public void ClickRegisterNowButton() {
        page.waitForSelector(Locators.REGISTER_BUTTON).click();
    }

	public boolean confirmRegistrationSuccess() {
       return page.waitForSelector(Locators.SUCCESS_MESSAGE).isVisible();
    }

	public boolean verifyRegisterpagenavigation() {
		page.waitForLoadState(LoadState.NETWORKIDLE);
		return page.url().endsWith("register");
	}

}
