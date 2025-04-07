package stepdefintion;

import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Homesteps {

	@Given("user is on home page")
	public void user_is_on_home_page() {
		Assert.assertTrue(Hooks.home.verifyHomepageNavigation());
	}

	@Given("user searches for {string} and adds the {string} to cart")
	public void user_searches_for_and_adds_the_to_cart(String string, String string2) throws InterruptedException {
		//Thread.sleep(2000);
		Hooks.home.searchProduct(string);
		//Thread.sleep(2000);
		Hooks.home.addToCart(string2);
	}

	@When("user verifies that the selected product is successfully added to cart")
	public void user_verifies_that_the_selected_product_is_successfully_added_to_cart() {
		Assert.assertTrue(Hooks.home.verifyProductAddedToCart());
	}

	@Then("user clicks on the checkout button")
	public void user_clicks_on_the_checkout_button() {
		Hooks.home.clickCheckoutButton();
	}

}
