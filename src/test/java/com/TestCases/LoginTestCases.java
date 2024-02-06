package com.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Resources.BaseClass;
import com.Resources.CommonMethods;
import com.Resources.Constants;

import PageObjectModel.LoginPageObjects;

public class LoginTestCases extends BaseClass {

	@Test(dependsOnMethods = "verifyValidRegistration")
	public void verifyValidLogin() throws IOException {
		
		LoginPageObjects lpo = new LoginPageObjects(driver);
		
		lpo.clickOnLogin().click();
//		lpo.enterEmail().sendKeys(email);
		lpo.enterEmail().sendKeys(RegisterTestCases.email); // static variable can be called by className.variableName
		lpo.enterPassword().sendKeys(Constants.validPassword);
		lpo.clickSubmit().click();
		
		CommonMethods.handleAssertion(String.valueOf(lpo.Logout().isDisplayed()), String.valueOf(true));
	}
	
	/*
	 * To intentionally fail the Login, we have not added depends on annotation
	 * to this method. So this method will run before register method, and
	 * we are trying to login before doing registration. So even if same mail ID
	 * is used for login and register, this login will fail.
	 */
	@Test
	public void verifyInvalidLogin() throws IOException {
		
		LoginPageObjects lpo = new LoginPageObjects(driver);
		
		lpo.clickOnLogin().click();
		lpo.enterEmail().sendKeys(RegisterTestCases.email);
		lpo.enterPassword().sendKeys(Constants.validPassword);
		lpo.clickSubmit().click();
		
		CommonMethods.handleAssertion(Constants.loginInvalidExpectedText, lpo.unsuccessfulText().getText());
	}
}
