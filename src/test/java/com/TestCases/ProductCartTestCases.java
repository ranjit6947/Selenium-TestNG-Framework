package com.TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Resources.BaseClass;
import com.Resources.CommonMethods;
import com.Resources.Constants;

import PageObjectModel.ProductCartPageObjects;

public class ProductCartTestCases extends BaseClass {
	
	@Test
	public void verifyProductPrice() throws IOException, InterruptedException {
		
		ProductCartPageObjects ppo = new ProductCartPageObjects(driver);
		
		ppo.searchBar().sendKeys(Constants.product);
		ppo.searchButton().click();
		
		List<WebElement> product = ppo.product();
		List<WebElement> price = ppo.price();
		
		String priceBeforeCart = "";
		
		for(int i = 0; i < product.size(); i++) {
			
			if(product.get(i).getText().equalsIgnoreCase(Constants.productName)) {
				
				priceBeforeCart = price.get(i).getText();
				product.get(i).click();
				break;
			}
		}
		
		ppo.processor().click();
		ppo.addtocart().click();
		
		/*
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String popuptext = wait.until(ExpectedConditions.visibilityOf(ppo.popup())).getText();
		*/
		
		CommonMethods.handleExplicitWait(driver, 10, ppo.popup());
		//Thread.sleep(2000);
		CommonMethods.handleAssertion(Constants.expectedPopupText, ppo.popup().getText());
		
		ppo.closePopup().click();
		
		Actions actions = new Actions(driver);
		actions.moveToElement(ppo.shoppingCart()).perform();
		
		ppo.goToCart().click();
		
		CommonMethods.handleAssertion(priceBeforeCart, ppo.priceAfterCart().getText());
	}
}
