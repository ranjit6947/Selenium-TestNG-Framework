package com.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Resources.BaseClass;
import com.Resources.Constants;

import PageObjectModel.RegisterPageObjects;

public class RegisterTestCases2 extends BaseClass {

	// Method 3
	public static String email = generateRandomEmailId();
	
	public static String generateRandomEmailId() {
		
		return "test" + System.currentTimeMillis() + "@gamil.com";
	}
	
	@Test
	public void verifyValidRegistration() throws IOException {
		
		RegisterPageObjects rpo = new RegisterPageObjects(driver);
		
		rpo.clickOnRegister().click();
		rpo.selectGender().click();
		rpo.enterFirstName().sendKeys(Constants.firstName);
		rpo.enterLastName().sendKeys(Constants.lastName);
		rpo.enterEmail().sendKeys(email);
		rpo.enterPassword().sendKeys(Constants.password);
		rpo.enterConfirmPassword().sendKeys(Constants.confirmPassword);
		rpo.clickOnSubmit().click();
		
		String expectedText = Constants.validExpectedText;
		String actualtext = rpo.successText().getText();
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualtext, expectedText);
		sa.assertAll();
	}
	
	@Test()
	public void verifyInalidRegistration() throws IOException {
		
		RegisterPageObjects rpo = new RegisterPageObjects(driver);
		
		rpo.clickOnRegister().click();
		rpo.selectGender().click();
		rpo.enterFirstName().sendKeys(Constants.firstName);
		rpo.enterLastName().sendKeys(Constants.lastName);
		rpo.enterEmail().sendKeys(Constants.invalidEmail);
		rpo.enterPassword().sendKeys(Constants.password);
		rpo.enterConfirmPassword().sendKeys(Constants.confirmPassword);
		rpo.clickOnSubmit().click();
		
		String expectedText = Constants.invalidExpectedText;
		String actualtext = rpo.unsuccessText().getText();
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualtext, expectedText);
		sa.assertAll();
	}
}
