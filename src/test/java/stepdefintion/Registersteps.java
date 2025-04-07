package stepdefintion;

import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Registersteps {

	@Given("user is on the home page")
	public void user_is_on_the_home_page() {
		Assert.assertTrue(Hooks.home.verifyHomepageNavigation());
	}

	@Given("user clicks on the Register button")
	public void user_clicks_on_the_register_button() {
		Hooks.home.ClickRegisterbutton();
	}

	@Given("user should land on the register page")
	public void user_should_land_on_the_register_page() {
		Assert.assertTrue(Hooks.register.verifyRegisterpagenavigation());
	}

	@When("user enters a valid username, password, and confirm password")
	public void user_enters_a_valid_username_password_and_confirm_password() throws InterruptedException {
		//Thread.sleep(2000);
		Hooks.register.getCredintials();
		Hooks.register.registerUser();
	}

	@When("user clicks on the Register Now button")
	public void user_clicks_on_the_button() {
		Hooks.register.ClickRegisterNowButton();
	}

	@Then("a registration successful message popup should appear")
	public void a_registration_successful_message_popup_should_appear() {
		Assert.assertTrue(Hooks.register.confirmRegistrationSuccess());
	}

	@Then("user should be navigated to the login page")
	public void user_should_be_navigated_to_the_login_page() {
		Assert.assertTrue(Hooks.login.verifyLoginPageNavigation());
	}

}
