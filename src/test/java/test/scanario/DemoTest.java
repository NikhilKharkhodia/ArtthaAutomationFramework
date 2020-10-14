package test.scanario;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;

import Generic.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class DemoTest extends BaseTest {
	 public static Logger log =LogManager.getLogger(BaseTest.class.getName());
	LoginPage lp;
	WebDriverWait wait;
	HomePage hp;
	@BeforeMethod
	public void setUP() throws InterruptedException {
		try {
			launchBrowser();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 1)
	
	public void varifyLoginPageUrl() {
		log.info("Varify current page Url");
		String loginpageurl = driver.getCurrentUrl();
		Assert.assertEquals(loginpageurl, "http://103.206.163.20:9097/mandiri/do/");
	}

	@Test(priority = 2,description = "verifying login page title test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify login page title test on Login Page")
	@Story("Story Name: To check login page title")
	public void varifyLoginPagetitle() {
		log.info("Varify page title");
		String loginpageTile = driver.getTitle();
		System.out.println("Login page tittle" + " " + loginpageTile);
		Assert.assertEquals(loginpageTile, "Mandiri");
	}
	@Test(priority = 3)
	public void varifyLoginPageLogo() {
		lp = new LoginPage(driver);
		boolean flag = lp.loginPageLogo();
		Assert.assertTrue(flag);
	

}
	@Test(priority = 4)
	public void loginTest() {
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

	}}
