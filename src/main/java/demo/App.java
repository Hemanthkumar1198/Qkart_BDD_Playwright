package demo;

import java.text.SimpleDateFormat;
import java.util.UUID;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class App {
	static Page page;

	public static void main(String[] args) throws InterruptedException {
		String timestamp = new SimpleDateFormat("ddMMyyyyHHmmss").format(new java.util.Date());
		String email = "Tester_" + timestamp;
		String password = "Password" + UUID.randomUUID();

		System.out.println("Generated Credentials: ");
		System.out.println("Email: " + email);
		System.out.println("Password: " + password);

		// Start Playwright
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			BrowserContext context = browser.newContext();
			page = context.newPage();

			// Navigate to the Application
			page.navigate("https://crio-qkart-frontend-qa.vercel.app/");
			page.waitForLoadState(LoadState.NETWORKIDLE);

			// Click on Register
			page.locator(".css-177pwqq").click();
			page.waitForSelector("[id='username']");

			// Fill Registration Details
			page.fill("[id='username']", email);
			page.fill("[id='password']", password);
			page.fill("[id='confirmPassword']", password);

			// Click Register Button
			page.locator("//button[text()='Register Now']").click();

			// Wait for Registration Success Message
			page.waitForSelector("//div[text()='Registered Successfully']");
			System.out.println("Registration Successful!");

			// Login Process
			page.fill("[id='username']", email);
			page.fill("[id='password']", password);
			page.click("//button[text()='Login to QKart']");

			// Wait for Search Bar & Search for Shoes
			page.waitForSelector("(//input[@placeholder='Search for items/categories'])[1]");
			page.fill("(//input[@placeholder='Search for items/categories'])[1]", "shoe");

			// Locate and Click "Add to Cart" for Nike Shoes
			page.waitForSelector("//p[@class='MuiTypography-root MuiTypography-body1 css-yg30e6']");
			Locator items = page.locator("//p[@class='MuiTypography-root MuiTypography-body1 css-yg30e6']");
			for (int i = 0; i < items.count(); i++) {
				if (items.nth(i).innerText().contains("Roadster Mens Running Shoes")) {
					items.nth(i).locator(
							"xpath=./ancestor::div[contains(@class,'MuiCard-root')]//button[text()='Add to cart']")
							.click();
					System.out.println("Roadster Mens Running Shoes added to cart!");
					break;
				}
			}
			page.waitForSelector("//div[@class='MuiBox-root css-1gjj37g']//div[text()='Roadster Mens Running Shoes']");
			page.locator("//div[@class='MuiBox-root css-1gjj37g']//div[text()='Roadster Mens Running Shoes']")
					.innerText().contains("Roadster Mens Running Shoes");
			System.out.println("order  is present in check out");

			page.waitForSelector("//button[text()='Checkout']").click();
			page.waitForSelector("[id='add-new-btn']").click();

			page.waitForSelector("[placeholder='Enter your complete address']")
					.fill("phone madi bro nane band iskotini @571113");
			page.locator("//button[text()='Add']").click();
			// Thread.sleep(2000);
			page.waitForLoadState(LoadState.NETWORKIDLE);
			//page.waitForSelector("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]");
//			retryClickWithVisibility(page,
//				    "(//p[@class='MuiTypography-root MuiTypography-body1 css-yg30e6'])[1]",
//				    3, // retries
//				    1000, // wait between retries in ms
//				    true // hover before click
//				);
			
			page.waitForSelector("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]").click();
			page.waitForSelector("//button[text()='PLACE ORDER']").click();
			if (page.waitForSelector("//div[@class='greeting-container MuiBox-root css-0']//h2").innerText()
					.contains("Yay! It's ordered")) {
				System.out.println("order placed");
			}

			System.out.println("Test Execution Completed!");
		}
	}
	
	public static void retryClickWithVisibility(Page page, String locatorStr, int maxRetries, int waitBetweenRetriesMillis, boolean hoverBeforeClick) {
	    Locator locator = page.locator(locatorStr);

	    for (int attempt = 1; attempt <= maxRetries; attempt++) {
	        try {
	            // Wait for element to be visible
	            //locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));
	        	//page.waitForSelector(locatorStr);
	            // Optional: Hover before click
	            if (hoverBeforeClick) {
	                locator.hover();
	            }

	            // Try clicking the element
	            locator.click();
	            System.out.println("Click successful on attempt: " + attempt);
	            //return;
	        } catch (Exception e) {
	            System.out.println("Attempt " + attempt + " failed: " + e.getMessage());
	            if (attempt < maxRetries) {
	                try {
	                    Thread.sleep(waitBetweenRetriesMillis);
	                } catch (InterruptedException ie) {
	                    Thread.currentThread().interrupt();
	                }
	            } else {
	                throw new RuntimeException("Click failed after " + maxRetries + " attempts", e);
	            }
	        }
	    }
	}

}
