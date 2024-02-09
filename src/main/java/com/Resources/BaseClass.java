package com.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public static WebDriver driver;
	public Properties properties = new Properties();

	public void initializeDriver() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\Resources\\data.properties");

		properties.load(fis);

		String browser = properties.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else {

			System.out.println("Please choose valid browser...!");
		}
	}

	// To take the screenshot and store in one folder-
	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		// 202312120744

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
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

	@BeforeSuite
	public void ExtentReport() {
		extentManager.setup();
	}

	@AfterSuite
	public void endReport() {
		extentManager.endReport();
	}

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
