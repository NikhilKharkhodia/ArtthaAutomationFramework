package test.scanario;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.pages.HomePage;
import com.pages.InvalidLoginPage;
import com.pages.LoginPage;
import com.pages.ManagePage;
import com.pages.NewCurrencyPage;

import Generic.BaseTest;

public class CreateCurrencyTest extends BaseTest {
	LoginPage lp;
	WebDriverWait wait;
	HomePage hp;
	InvalidLoginPage inl;
	JavascriptExecutor js;
	ManagePage mp;

	Faker faker = new Faker();
	public static Logger log =LogManager.getLogger(BaseTest.class.getName());

	@BeforeMethod
	public void setUP() throws InterruptedException {
		try {
			launchBrowser();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 1)
	public void loginTest() throws InterruptedException {
		log.info("Enter UserName");
		lp = new LoginPage(driver);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(lp.enterUserName()));
		lp.enterUserName().sendKeys("9800000007");
		wait.until(ExpectedConditions.visibilityOf(lp.enterUserPassword()));
		lp.enterUserPassword().sendKeys("mandiri");
		lp.clickLoginButton().click();
		hp = new HomePage(driver);
		wait.until(ExpectedConditions.visibilityOf(hp.welcomeuser()));
		if (hp.welcomeuser().isDisplayed()) {
			System.out.println("User Login into HomePage");
		}

		wait.until(ExpectedConditions.visibilityOf(hp.clickmanageOption()));
		hp.clickmanageOption().click();
		mp = new ManagePage(driver);
		mp.clickCreateNewCurrency().click();

		NewCurrencyPage ncp = new NewCurrencyPage(driver);
		wait.until(ExpectedConditions.visibilityOf(ncp.enterCurrencyName()));
		String firstname = faker.name().firstName();
		ncp.enterCurrencyName().sendKeys(firstname);
		ncp.enterSymbol().sendKeys("$");
		ncp.enterdescription().sendKeys("Testing Automation");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		ncp.entersaveButton().click();
		Thread.sleep(5000);

		String MainWindow = driver.getWindowHandle();

		// To handle all new opened window.
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

				// Switching to Child window
				driver.switchTo().window(ChildWindow);
				String alertMessage = driver.findElement(By.xpath(
						"//div[@class='ui small modal alertPopUp transition visible active']//div[@id='alertContent']"))
						.getText();
				System.out.println(alertMessage);
				ncp.clickonpopup().click();
				driver.close();

			}

		}
	}
}
