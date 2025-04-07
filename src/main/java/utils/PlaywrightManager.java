package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightManager {
	
	private static PlaywrightManager instance;
	private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;
    
    private PlaywrightManager() {
    	Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        BrowserContext context = browser.newContext();
        page = context.newPage();
        
    }
    
    public static PlaywrightManager getPlaywrightInstance() {
    	if(instance==null) {
    		instance = new PlaywrightManager();
    	}
    	return instance;
    }
    
    public Page getPage() {
    	return page;
    }
    
    public static void close() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

}
