package com.Resources;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class CommonMethods {

	public static void handleAssertion(String actualtext, String expectedText) {
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualtext, expectedText);
		sa.assertAll();
	}
	
	public static void handleExplicitWait(WebDriver driver, int seconds, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
