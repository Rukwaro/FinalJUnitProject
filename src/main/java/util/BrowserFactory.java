package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	// Static global variable, so all methods can use
	static WebDriver driver;

	// Create a method to start browser and return WebDriver
	public static WebDriver startBrowser() {

		// Set Chrome Driver Properties
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		// Create ChromeDriver object to launch Chrome browser
		driver = new ChromeDriver();

		// Delete all cookies
		driver.manage().deleteAllCookies();

		// Maximize the browser window
		driver.manage().window().maximize();

		// Set implicit wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Get the company website
		driver.get("http://techfios.com/test/107/");

		// Return the driver
		return driver;
	}
}
