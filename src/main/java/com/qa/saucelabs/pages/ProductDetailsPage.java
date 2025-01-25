package com.qa.saucelabs.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductDetailsPage extends BasePage {
	
	@AndroidFindBy(accessibility="test-ADD TO CART")
	private WebElement addToCartButton;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView[@content-desc='test-Inventory item page']")
	private WebElement inventoryPage;
	
	@AndroidFindBy(accessibility="test-Price")
	private WebElement productPrice;

	public ProductDetailsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	
	public boolean isAddToCartButtonVisible() {
		return addToCartButton.isEnabled();
	}
	
	public String getProductPrice() {
		//actions.androidScroll(inventoryPage);
		
		Dimension windowSize = getDriver().manage().window().getSize();
		actions.androidScroll(300, 560, 250, 440, "down");
		return actions.getText(productPrice);
	}
}
