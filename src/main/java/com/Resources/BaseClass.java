package com.Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public WebDriver driver;
	public Properties properties = new Properties();
	
	public void initializeDriver() throws IOException {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\Resources\\data.properties");

		properties.load(fis);

		String browser = properties.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		} 
		else if (browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		}
		else {
			
			System.out.println("Please choose valid browser...!");
		}
	}
	
	// Method 1
//  public static String generateRandomEmailId() {
//		
//		return "test" + System.currentTimeMillis() + "@gamil.com";
//	}
//    
//  public static String email = generateRandomEmailId();
    
	
	// Method 2
//	public static String email = "";
//	
//	@BeforeSuite
//    public static void generateRandomEmailId() {
//		
//    	email = "test" + System.currentTimeMillis() + "@gamil.com";
//	}
	
	@BeforeMethod
	public void launchBrowser() throws IOException {
		
		initializeDriver();
		driver.get(properties.getProperty("url"));
	}
	
	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
}
