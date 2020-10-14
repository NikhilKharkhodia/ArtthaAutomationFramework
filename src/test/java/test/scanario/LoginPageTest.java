package test.scanario;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.pages.HomePage;
import com.pages.InvalidLoginPage;
import com.pages.LoginPage;

import com.utill.TestUtil;

import Generic.BaseTest;

public class LoginPageTest extends BaseTest {
	LoginPage lp;
	WebDriverWait wait;
	HomePage hp;
	InvalidLoginPage inl;

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
		String loginpageurl = driver.getCurrentUrl();
		Assert.assertEquals(loginpageurl, "http://103.206.163.20:9097/mandiri/do/login");
	}

	@Test(priority = 2)
	public void varifyLoginPagetitle() {
		String loginpageTile = driver.getTitle();
		System.out.println("Login page tittle" + " " + loginpageTile);
		Assert.assertEquals(loginpageTile, "Mandiri");
	}

	@Test(priority = 3)
	public void varifyLoginPageLogo() {
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

	}

	@DataProvider
	public Object[][] getUserData() {
		Object data[][] = TestUtil.getTestData("Sheet2");
		return data;
	}

	@Test(enabled = true, dataProvider = "getUserData", priority = 5)
	public void test1(String username, String userpassword) throws InterruptedException, AWTException {

		Thread.sleep(2000);
		LoginPage lp = new LoginPage(driver);
		lp.registerNewMembers(username, userpassword);
		wait = new WebDriverWait(driver, 10);
		lp.clickLoginButton().click();
		InvalidLoginPage inl = new InvalidLoginPage(driver);

		wait.until(ExpectedConditions.visibilityOf(inl.invaliduserlogin()));
		if (inl.invaliduserlogin().isDisplayed()) {
			System.out.println("Login with Invalid Username and Password");
		} else {
			System.out.println("Please check the landingPage");
		}

	}
}
