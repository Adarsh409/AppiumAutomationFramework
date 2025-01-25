package com.qa.saucelabs.stepdefs;

import com.qa.saucelabs.pages.BasePage;
import com.qa.saucelabs.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	BasePage basePage = new BasePage();
	@Before
	public void beforeScenario() {
		basePage.launchApp();
	}

	@After
	public void afterScenario() {
//		LoginPage loginPage = new LoginPage();
//		if (!loginPage.isLoginButtonVisible()) {
//			basePage.logOut();
//		}
		basePage.terminateApp();
		

	}

}
