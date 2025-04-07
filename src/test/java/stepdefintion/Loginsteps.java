package stepdefintion;

import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Registerpage;

public class Loginsteps {

	@Given("user is on login page")
	public void user_is_on_login_page() {
		Assert.assertTrue(Hooks.login.verifyLoginPageNavigation());
	}

	@Given("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
		Hooks.login.loginUser(Registerpage.email, Registerpage.password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		Hooks.login.clickLoginButton();
	}

	@Then("user should be able to login successfully for QKart application")
	public void user_should_be_able_to_login_successfully_for_q_kart_application() {
		Assert.assertTrue(Hooks.login.verifyLoginsuccessfull());
	}

}
