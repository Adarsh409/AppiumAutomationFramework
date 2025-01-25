package com.qa.saucelabs.utils;

import io.appium.java_client.AppiumDriver;

public class TestParams {
	private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	private static ThreadLocal<String> udid = new ThreadLocal<String>();
	private static ThreadLocal<String> platformName = new ThreadLocal<String>();
	public static void setPlatformName(String platformName) {
		TestParams.platformName.set(platformName);
	}

	public static String getPlatformName() {
		return TestParams.platformName.get();
	}

	public static void setUdid(String udid) {
		TestParams.udid.set(udid);
	}

	public static String getUdid() {
		return TestParams.udid.get();
	}

	public static void setDriver(AppiumDriver driver) {
		TestParams.driver.set(driver);
	}

	public static AppiumDriver getDriver() {
		return TestParams.driver.get();
	}

}
