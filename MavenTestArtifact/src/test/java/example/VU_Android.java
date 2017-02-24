package example;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.gargoylesoftware.htmlunit.javascript.host.ScreenOrientation;
import com.xbosoft.automation.Util_VU;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.JavascriptExecutor;

import pageFactory.AccountPage;
import pageFactory.SignInPage;

public class VU_Android {
	private WebDriver driver;
	private String scrFolder;
	public String url;
	public String currentUserID;
	public WebDriverWait wait;

	public void takeScreenshot(String fileName) throws IOException, Throwable {
		Thread.sleep(3000);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(scrFolder + "/" + fileName + ".png"));
	}

//	public void waitForLoad(WebDriver driver) {
//		new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
//				.executeScript("return document.readyState").equals("complete"));
//	}

	@SuppressWarnings("rawtypes")
	@BeforeTest
	public void setUp() throws Exception {

		// Set Chrome driver
		System.setProperty("webdriver.chrome.driver", Util_VU.ChromedriverPath);

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
		driver.manage().timeouts().implicitlyWait(Util_VU.WAIT_TIME, TimeUnit.SECONDS);

		// create folder for screenshots
		scrFolder = "d:/Result/"
				+ new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(Calendar.getInstance().getTime()).toString();
		new File(scrFolder).mkdir();

		// Go to BaseURL
		driver.get(Util_VU.BASEURL);

	}

	/**
	 * The test below covers 1 VU-8:Login-No Username/Password 2
	 * VU-46:Login-Wrong Username/Password 3 VU-10:Login-Correct
	 * Username/Password 4 VU-49:Login-2-Step Verification-With 2-step
	 * verification completed in enrollment
	 * 
	 * @throws Throwable
	 */

	@Test(priority = 0)

	public void login() throws Throwable {

		// Create Login Page object
		SignInPage objSignInPage = new SignInPage(driver);
		// Take screenshots
		takeScreenshot("loginPage");
		
//		((AppiumDriver) driver).rotate(ScreenOrientation.LANDSCAPE);

		// //VU-8:Login-No Username/Password
		// objSignInPage.signInNoUsernamePassword();
		// // Take screenshots
		// takeScreenshot("loginPageNoUsernamePassword");
		//
		// //VU-46:Login-Wrong Username/Password
		// objSignInPage.signInWrongUsernamePassword();
		// // Take screenshots
		// takeScreenshot("loginWrongUsernamePassword");

		// VU-10:Login-Correct Username/Password
		objSignInPage.signIn(Util_VU.LOGIN_ID, Util_VU.PASSWORD);


	}

}

