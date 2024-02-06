package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPageObjects {

	public WebDriver driver;

	private By Register = By.xpath("//a[text()='Register']");
	private By Gender = By.xpath("//input[@value='M']");
	private By Firstname = By.xpath("//input[@id='FirstName']");
	private By Lastname = By.xpath("//input[@id='LastName']");
	private By Email = By.xpath("//input[@id='Email']");
	private By Password = By.xpath("//input[@id='Password']");
	private By ConfirmPassword = By.xpath("//input[@id='ConfirmPassword']");
	private By RegisterButton = By.xpath("//input[@id='register-button']");
	private By registrationCompletedText = By.xpath("//div[@class='result']");
	private By registrationNotCompletedText = By.xpath("//li[contains(text(),'already')]");

	public RegisterPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement clickOnRegister() {
		return driver.findElement(Register);
	}

	public WebElement selectGender() {
		return driver.findElement(Gender);
	}

	public WebElement enterFirstName() {
		return driver.findElement(Firstname);
	}

	public WebElement enterLastName() {
		return driver.findElement(Lastname);
	}

	public WebElement enterEmail() {
		return driver.findElement(Email);
	}

	public WebElement enterPassword() {
		return driver.findElement(Password);
	}

	public WebElement enterConfirmPassword() {
		return driver.findElement(ConfirmPassword);
	}

	public WebElement clickOnSubmit() {
		return driver.findElement(RegisterButton);
	}

	public WebElement successText() {
		return driver.findElement(registrationCompletedText);
	}

	public WebElement unsuccessText() {
		return driver.findElement(registrationNotCompletedText);
	}
}
