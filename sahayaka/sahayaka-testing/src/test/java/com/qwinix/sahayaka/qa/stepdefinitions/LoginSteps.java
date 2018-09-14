package com.qwinix.sahayaka.qa.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.qwinix.sahayaka.qa.BaseDriver;
import com.qwinix.sahayaka.qa.steps.UserSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	UserSteps objuser= new UserSteps();
   BaseDriver objBD = new BaseDriver();
   WebDriver driver = BaseDriver.driver;
	@Given("^I am on Hobbes login page$")
	public void i_am_on_Hobbes_login_page() throws Throwable {
		objuser.openUrl();
	}

	@When("^I enter my email and password and click on log in button$")
	public void i_enter_my_email_and_password_and_click_on_log_in_button() throws Throwable {
	    objuser.Login();
	}

	@Then("^I should be able to login successfully$")
	public void i_should_be_able_to_login_successfully() throws Throwable {
//		objuser.verifyLogin();
	}
}
