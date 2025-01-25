package com.qa.saucelabs.stepdefs;

import org.testng.Assert;

import com.qa.saucelabs.pages.ProductDetailsPage;
import com.qa.saucelabs.pages.ProductsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepDefs {
	ProductsPage productsPage = new ProductsPage();
	ProductDetailsPage productDetailsPage;

	@When("User clicks on product with title {string}")
	public void user_clicks_product(String productTitle) {
		productDetailsPage = productsPage.selectProduct(productTitle);
	}

	@Then("Product price {string} should appear in Product Details page")
	public void product_price_should_appear_in_product_details_page(String expectedProductPrice) {
		Assert.assertEquals(productDetailsPage.getProductPrice(), expectedProductPrice);
	}

	@Then("Add to cart button should be visible")
	public void add_to_cart_button_should_be_visible() {
		Assert.assertTrue(productDetailsPage.isAddToCartButtonVisible());
	}

}
