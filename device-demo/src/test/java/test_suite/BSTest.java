package test_suite;

	
	import org.openqa.selenium.By;
	import org.openqa.selenium.Platform;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;

	import java.net.URL;

	public class BSTest {

	  public static final String USERNAME = "nanwang2";
	  public static final String AUTOMATE_KEY = "k7mcwbHLFnqcqYNf9Mv2";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	  public static void main(String[] args) throws Exception {

	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", "chrome");
	    caps.setCapability("browserstack.debug", "true");
	    caps.setCapability("build", "First build");

	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    driver.get("https://68.66.0.106");
//	    WebElement element = driver.findElement(By.name("q"));

//	    element.sendKeys("BrowserStack");
//	    element.submit();

	    System.out.println(driver.getTitle());
	    driver.quit();

	  }
	}

