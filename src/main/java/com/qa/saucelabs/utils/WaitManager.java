package com.qa.saucelabs.utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitManager {
	private static final long waitTime = 20;
	private static WebDriverWait wait;
	public WaitManager() {
		wait = new WebDriverWait(TestParams.getDriver(),Duration.ofSeconds(waitTime));
	}
	
	public void waitForElementToBeVisibile(WebElement element) {
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForRElementToBeClickable(WebElement element) {
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
