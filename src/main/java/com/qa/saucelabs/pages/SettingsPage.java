package com.qa.saucelabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingsPage extends BasePage {
	
	@AndroidFindBy(accessibility="test-LOGOUT")
	private WebElement logOutButton;

	public SettingsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	
	public LoginPage clickLogOutButton() {
		actions.click(logOutButton);
		return new LoginPage();
	}
	
	

}
