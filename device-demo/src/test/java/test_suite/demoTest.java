package test_suite;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.gargoylesoftware.htmlunit.javascript.host.ScreenOrientation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class demoTest {
	private WebDriver driver;


	@SuppressWarnings("rawtypes")
	@BeforeTest
	public void setUp() throws Exception {

		// Set Chrome driver
		System.setProperty("webdriver.chrome.driver", "./browser-drivers/chromedriver.exe");

		// Create object of DesiredCapabilities class and specify android
		// platform
		DesiredCapabilities capabilities = DesiredCapabilities.android();

		// set the capability to execute test in Chrome browser
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);

		// set the capability to execute our test in Android Platform
		capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);

		// we need to define platform name
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		// Set the device name as well (you can give any name)
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "my phone");

		// set the android version as well
		capabilities.setCapability(MobileCapabilityType.VERSION, "5.0.1");

		// set the android version as well
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "0");

		// Create object of URL class and specify the appium server address
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		// Create object of AndroidDriver class and pass the url and capability
		// that we created
		// @SuppressWarnings("rawtypes")
		driver = new AndroidDriver(url, capabilities);

		// Setting Wait Time
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Go to BaseURL
		driver.get("http://google.com");

	}

	@Test				
	public void testEasy() {	
		driver.get("http://www.guru99.com/selenium-tutorial.html");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Free Selenium Tutorials")); 		
	}	

			
	@AfterTest
	public void afterTest() {
		driver.quit();			
	}	

}

