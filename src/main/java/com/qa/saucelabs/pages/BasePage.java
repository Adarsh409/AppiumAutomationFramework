package com.qa.saucelabs.pages;

import org.openqa.selenium.WebElement;

import com.qa.saucelabs.utils.ActionsFactory;
import com.qa.saucelabs.utils.PropertyManager;
import com.qa.saucelabs.utils.TestParams;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BasePage {
	ActionsFactory actions;
	@AndroidFindBy(accessibility = "test-Menu")
	private WebElement settingsButton;
	

	public BasePage() {
		actions = new ActionsFactory();
	}

	public SettingsPage clickSettingsButton() {
		actions.click(settingsButton);
		return new SettingsPage();
	}

	public AppiumDriver getDriver() {
		return TestParams.getDriver();
	}

	public String getPlatformName() {
		return TestParams.getPlatformName();
	}

	public LoginPage logOut() {
		SettingsPage settingsPage = clickSettingsButton();
		return settingsPage.clickLogOutButton();

	}

	public void terminateApp() {
		switch (getPlatformName()) {
		case "Android": {
			((AndroidDriver) getDriver()).terminateApp(PropertyManager.getProps().getProperty("appPackage"));
			break;
		}
		case "IOS": {
			break;
		}
		}
	}

	public void launchApp() {
		switch (getPlatformName()) {
		case "Android": {
			((AndroidDriver) getDriver()).activateApp(PropertyManager.getProps().getProperty("appPackage"));
			
			break;
		}
		case "IOS": {
			break;
		}
		}
	}
}
