package Generic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;


import com.utill.WebEventListener;

public class BaseTest {
	
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public static String configProperty = "./src/main/java/propertiesFiles/config.properties";
	protected static Utilities utilities = new Utilities();
	String CHROME_KEY = utilities.getPropertyValue(configProperty, "CHROME_KEY");
	String CHROME_VALUE = utilities.getPropertyValue(configProperty, "CHROME_VALUE");
	String FIREFOX_KEY = utilities.getPropertyValue(configProperty, "FIREFOX_KEY");
	String FIREFOX_VALUE = utilities.getPropertyValue(configProperty, "FIREFOX_VALUE");
	String ITO = utilities.getPropertyValue(configProperty, "ITO");
	String PLT = utilities.getPropertyValue(configProperty, "PLT");

	protected static WebDriver driver = null;

	public void launchBrowser() throws FileNotFoundException, IOException {

		System.out.println("Ready to launch a browser");

		if (utilities.getPropertyValue(configProperty, "browser").contains("chrome")){
			System.out.println("**Launching Chrome Browser**");
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			ChromeOptions options = new ChromeOptions();
			if (utilities.getPropertyValue(configProperty, "browser").contains("headless")) {
				System.out.println("**Headless Browser**");
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver();
		} else if (utilities.getPropertyValue(configProperty, "browser").equalsIgnoreCase("firefox")) {
			System.out.println("**Launching Firefox Browser**");
			System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
			driver = new FirefoxDriver();
		}
		
		// Method of WebEventListener
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(ITO), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(PLT), TimeUnit.SECONDS);
		driver.get(utilities.getPropertyValue(configProperty, "url"));
	}

	// Closing the browser 
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		System.out.println("I am clossing Browser ");
		driver.quit();
	}

}
