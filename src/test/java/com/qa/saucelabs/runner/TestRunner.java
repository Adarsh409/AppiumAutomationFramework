package com.qa.saucelabs.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.saucelabs.utils.DriverManager;
import com.qa.saucelabs.utils.ServerManager;
import com.qa.saucelabs.utils.TestParams;

import io.appium.java_client.AppiumDriver;



@CucumberOptions(
		plugin = { "pretty", "html:target/cucumber/report.html", "summary","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
		features = {".//Features"}, 
		glue = "com.qa.saucelabs.stepdefs", 
		monochrome = true,
		
		dryRun=false
		)

public class TestRunner extends AbstractTestNGCucumberTests{

	@Parameters({ "udid", "platformName" })
	@BeforeTest
	public void setUp(String udid, String platformName) {
		TestParams.setPlatformName(platformName);
		TestParams.setUdid(udid);
		ServerManager.startServer();
		AppiumDriver driver = DriverManager.initializeDriver();
		
		TestParams.setDriver(driver);

	}

	@AfterTest
	public void tearDown() {
		TestParams.getDriver().quit();
		ServerManager.getServer().stop();
	}

}
