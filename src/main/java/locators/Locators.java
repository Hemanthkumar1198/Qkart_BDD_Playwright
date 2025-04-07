package locators;

public class Locators {
	
	//homepage
	public static final String HOMEPAGE_HEADING_LOCATOR = "//span[text()=' FASTEST DELIVERY ']";
	public static final String HP_REGISTER_BUTTON = ".css-177pwqq";
	public static final String SEARCH_BUTTON = "//div[@class='MuiFormControl-root MuiTextField-root search-desktop css-i44wyl']//input[@name='search']";
	public static final String PRODUCT_LIST = "//p[@class='MuiTypography-root MuiTypography-body1 css-yg30e6']";
	public static final String PRODUCT_SELECTION = "xpath=./ancestor::div[contains(@class,'MuiCard-root')]//button[text()='Add to cart']";
	public static final String VERIFY_CART_PRODUCT_NAME = "//div[@class='MuiBox-root css-1gjj37g']//div[text()='Roadster Mens Running Shoes']";
	public static final String CHECKOUT_BUTTON = "//button[text()='Checkout']";
	
	//Registerpage
	public static final String USERNAME_INPUT = "[id='username']";
    public static final String PASSWORD_INPUT = "[id='password']";
    public static final String CONFIRM_PASSWORD_INPUT = "[id='confirmPassword']";
    public static final String REGISTER_BUTTON = "//button[text()='Register Now']";
    public static final String SUCCESS_MESSAGE = "//div[text()='Registered Successfully']";
    
    //loginpage
//    public static final String USERNAME_INPUT = "[id='username']";
//	public static final String PASSWORD_INPUT = "[id='password']";
	public static final String LOGIN_BUTTON = "//button[text()='Login to QKart']";

	//checkoutpgae
	public static final String PLACE_ORDER_BUTTON = "//button[text()='PLACE ORDER']";
	public static final String ADDRESS_TEXT_FIELD = "[placeholder='Enter your complete address']";
	public static final String ADD_ADDRESS_BUTTON = "//button[text()='Add']";
	public static final String SELECT_ADDRESS = "(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]";
	public static final String ADD_NEW_ADDRESS_BUTTON = "[id='add-new-btn']";
	
	//orderconfirmationpage
	public static final String ORDER_PLACED_CONFIRMATION = "//div[@class='greeting-container MuiBox-root css-0']//h2";
	
}
