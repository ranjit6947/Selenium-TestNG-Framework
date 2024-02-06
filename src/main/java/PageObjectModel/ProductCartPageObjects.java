package PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductCartPageObjects {

	public WebDriver driver;

	private By searchBar = By.xpath("//input[@value='Search store']");
	private By searchButton = By.xpath("//input[@value='Search']");
	private By product = By.xpath("//h2[@class='product-title']/a");
	private By price = By.xpath("//span[@class='price actual-price']");
	private By processor = By.xpath("//input[@value='96']");
	private By addToCart = By.xpath("//input[@id='add-to-cart-button-75']");
	private By popup = By.xpath("//p[@class='content']");
	private By closePopup = By.xpath("//span[@class='close']");
	private By shoppingCart = By.xpath("(//span[@class='cart-label'])[1]");
	private By goToCart = By.xpath("//input[@value='Go to cart']");
	private By priceAfterCart = By.xpath("//span[@class='product-price order-total']");

	public ProductCartPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement searchBar() {
		return driver.findElement(searchBar);
	}
	
	public WebElement searchButton() {
		return driver.findElement(searchButton);
	}

	public List<WebElement> product() {
		return driver.findElements(product);
	}

	public List<WebElement> price() {
		return driver.findElements(price);
	}

	public WebElement processor() {
		return driver.findElement(processor);
	}

	public WebElement addtocart() {
		return driver.findElement(addToCart);
	}
	
	public WebElement popup() {
		return driver.findElement(popup);
	}
	
	public WebElement closePopup() {
		return driver.findElement(closePopup);
	}
	
	public WebElement shoppingCart() {
		return driver.findElement(shoppingCart);
	}
	
	public WebElement goToCart() {
		return driver.findElement(goToCart);
	}
	
	public WebElement priceAfterCart() {
		return driver.findElement(priceAfterCart);
	}
}
