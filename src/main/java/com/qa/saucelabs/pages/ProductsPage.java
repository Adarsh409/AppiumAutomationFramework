package com.qa.saucelabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"PRODUCTS\"]")
	private WebElement productsTitle;

	public ProductsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	public String getProductsTitle() {
		return actions.getText(productsTitle);
	}

	public ProductDetailsPage selectProduct(String productTitle) {
		switch (getPlatformName()) {
		case "Android": {
			getDriver().findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Sauce Labs Onesie\"))"))
					.click();
			break;
		}
		case "IOS": {

		}
		}
		return new ProductDetailsPage();
	}

	public String getProductPrice(String productTitle) {
		return getDriver()
				.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + productTitle
						+ "']//parent::android.view.ViewGroup//android.widget.TextView[@content-desc='test-Price']"))
				.getText();
	}

}
