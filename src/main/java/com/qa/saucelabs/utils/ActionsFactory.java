package com.qa.saucelabs.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

public class ActionsFactory {
	private WaitManager wait;
	public ActionsFactory() {
			wait = new WaitManager();
	}
	
	
	public void click(WebElement element) {
		wait.waitForRElementToBeClickable(element);
		element.click();
	}
	
	public void enterText(WebElement element,String text) {
		wait.waitForElementToBeVisibile(element);
		element.sendKeys(text);
	}
	
	public String getText(WebElement element) {
		wait.waitForElementToBeVisibile(element);
		return element.getText();
	}
	
	public void androidScroll(int left,int top,int width,int height,String direction) {
		JavascriptExecutor js = ((JavascriptExecutor)TestParams.getDriver());
		js.executeScript("mobile:scrollGesture", ImmutableMap.of(
				"left",left,
				"top",top,
				"width",width,
				"height",height,
				"percent",1,
				"direction",direction
				
				));
		
	}
	
	public void androidScroll(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)TestParams.getDriver());
		js.executeScript("mobile:scrollGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement) element).getId(),
				"percent",0.75,
				"direction","down"
				
				));
	}

}
