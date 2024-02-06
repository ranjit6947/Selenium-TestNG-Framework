package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {

	public WebDriver driver;
	
	private By Login = By.xpath("//a[text()='Log in']");
	private By Email = By.xpath("//input[@id='Email']");
	private By Password = By.xpath("//input[@id='Password']");
	private By LoginButton = By.xpath("//input[@value='Log in']");
	private By LogoutButton = By.xpath("//a[@href='/logout']");
	private By unsuccessful = By.xpath("//span[contains(text(),'unsuccessful')]");
	
	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement clickOnLogin() {
		return driver.findElement(Login);
	}
	
	public WebElement enterEmail() {
		return driver.findElement(Email);
	}
	
	public WebElement enterPassword() {
		return driver.findElement(Password);
	}
	
	public WebElement clickSubmit() {
		return driver.findElement(LoginButton);
	}
	
	public WebElement Logout() {
		return driver.findElement(LogoutButton);
	}
	
	public WebElement unsuccessfulText() {
		return driver.findElement(unsuccessful);
	}
}
