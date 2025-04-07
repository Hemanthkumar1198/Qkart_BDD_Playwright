package stepdefintion;

import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Checkoutsteps {
	
	@Given("user is on the checkout page")
	public void user_is_on_the_checkout_page() {
	   Assert.assertTrue(Hooks.checkout.isUserOnCheckoutPage());
	}
	@Given("user clicks on the Add New Address button")
	public void user_clicks_on_the_Add_New_Address_button() {
		Hooks.checkout.clickAddNewAddressButton();
	}
	@When("user enters {string} and clicks on the Add button")
	public void user_enters_and_clicks_on_the_button(String string) {
		Hooks.checkout.enterAddress(string);
		Hooks.checkout.AddAddressbutton();
	}
	@When("user selects the address to deliver the product")
	public void user_selects_the_address_to_deliver_the_product() {
		Hooks.checkout.selectAddress();
	}
	@When("user clicks on the Place Order button")
	public void user_clicks_on_the_Place_Order_button() {
		Hooks.checkout.getPlaceOrderButton();
	}
	@Then("the message {string} should appear confirming the order is placed")
	public void the_message_should_appear_confirming_the_order_is_placed(String string) {
		Hooks.confirmorder.verifyOrderConfirmation(string);
	}

}
