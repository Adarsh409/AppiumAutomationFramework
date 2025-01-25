package com.qa.saucelabs.stepdefs;

import org.testng.Assert;

import com.qa.saucelabs.pages.LoginPage;
import com.qa.saucelabs.pages.ProductsPage;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {
	
	LoginPage loginPage;
	ProductsPage productsPage;
	
	
	
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		loginPage = new LoginPage();
	}
	
	@When("User enters {string} username and {string} password")
	public void user_enters_username_and_password(String userName, String password) {
	   loginPage.enterUserName(userName);
	   loginPage.enterPassword(password);
	}
	@When("User clicks login button")
	public void user_clicks_login_button() {
	    productsPage = loginPage.clickLoginButton();
	}
	@Then("User should should land on Products page with title {string}")
	public void user_should_should_land_on_products_page_with_title(String expectedProductsTitle) {
	    Assert.assertEquals(productsPage.getProductsTitle(), expectedProductsTitle);
	}

}
