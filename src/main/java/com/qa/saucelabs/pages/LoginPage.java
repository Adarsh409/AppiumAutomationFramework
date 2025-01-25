package com.qa.saucelabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage{
	
	@AndroidFindBy(accessibility="test-Username")
	private WebElement userNameField;
	
	@AndroidFindBy(accessibility="test-Password")
	private WebElement passwordField;
	
	@AndroidFindBy(accessibility="test-LOGIN")
	private WebElement loginButton;
	
	
	public LoginPage() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	
	public void enterUserName(String username) {
		actions.enterText(userNameField,username);
	}
	
	public void enterPassword(String password) {
		actions.enterText(passwordField,password);
	}
	
	public ProductsPage clickLoginButton() {
		actions.click(loginButton);
		return new ProductsPage();
	}
	
	public boolean isLoginButtonVisible() {
		return loginButton.isEnabled();
	}
	
	

}
