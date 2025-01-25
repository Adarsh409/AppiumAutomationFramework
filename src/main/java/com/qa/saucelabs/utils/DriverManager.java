package com.qa.saucelabs.utils;

import java.io.File;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class DriverManager {

	public static AppiumDriver initializeDriver() {
		String platformName = TestParams.getPlatformName();
		String appsPath = "src"+File.separator+"test"+File.separator+"resources"+File.separator+"Apps"+File.separator+"SauceLabsDemo.apk";
		switch (platformName) {
		case "IOS": {
			XCUITestOptions options = new XCUITestOptions();
			options.setUdid(TestParams.getUdid());
			options.setPlatformName(TestParams.getPlatformName());
			options.setBundleId(PropertyManager.getProps().getProperty("bundleId"));
			return new IOSDriver(ServerManager.getServer().getUrl(), options);

		}
		case "Android": {
			UiAutomator2Options options = new UiAutomator2Options();
			options.setUdid(TestParams.getUdid());
			options.setPlatformName(TestParams.getPlatformName());
		options.setApp(appsPath);
			options.setAppPackage(PropertyManager.getProps().getProperty("appPackage"));
			options.setAppActivity(PropertyManager.getProps().getProperty("appActivity"));
			options.setUnlockType(PropertyManager.getProps().getProperty("unlockType"));
			options.setUnlockKey(PropertyManager.getProps().getProperty("pin"));
			
			return new AndroidDriver(ServerManager.getServer().getUrl(), options);

		}
		}
		return null;
	}

}
