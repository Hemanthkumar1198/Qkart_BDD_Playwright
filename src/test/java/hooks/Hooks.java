package hooks;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.Checkoutpage;
import pages.Homepage;
import pages.Loginpage;
import pages.OrderCofirmationPage;
import pages.Registerpage;
import utils.PlaywrightManager;

public class Hooks {

	Page page;

	public static Homepage home;
	public static Loginpage login;
	public static Registerpage register;
	public static Checkoutpage checkout;
	public static OrderCofirmationPage confirmorder;

	@Before
	public void set(Scenario scenario) {
		System.out.println("=== START Scenario: " + scenario.getName() + " ===");
		page = PlaywrightManager.getPlaywrightInstance().getPage();
		
		home = new Homepage(page);
		register = new Registerpage(page);
		login = new Loginpage(page);
		checkout = new Checkoutpage(page);
		confirmorder = new OrderCofirmationPage(page);
		
		page.navigate("https://crio-qkart-frontend-qa.vercel.app/");
		page.waitForLoadState(LoadState.NETWORKIDLE);
	}

	@After
	public void tearDown(Scenario scenario) {
		System.out.println("=== END Scenario: " + scenario.getName() + " ===");

		if (scenario.isFailed()) {
			byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
			scenario.attach(screenshot, "image/png", "screenshot-on-fail");
		}

		PlaywrightManager.close();

	}

}
