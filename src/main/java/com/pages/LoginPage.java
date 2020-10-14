package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseTest;
import io.qameta.allure.Step;

public class LoginPage extends BaseTest {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy(xpath = "//input[@id='fruitMobilenumber']")
	@CacheLookup
	WebElement Username;

	private @FindBy(xpath = "//input[@id='fruitPassword']") 
	@CacheLookup
	WebElement UserPassword;

	private @FindBy(xpath = "//button[@class='ui red button']")
	@CacheLookup 
	WebElement Login;

	private @FindBy(xpath = "//div[@class='column']//img[@class='logoImg']")
	@CacheLookup 
	WebElement Logo;

	private @FindBy(xpath = "//div[@class='formInner ui middle aligned center aligned grid']")
	@CacheLookup 
	WebElement colour;

	@Step("Enter Username....")
	public WebElement enterUserName() {
		return Username;
	}

	@Step("Enter user password....")
	public WebElement enterUserPassword() {
		return UserPassword;
	}

	@Step("Click on Login button....")
	public WebElement clickLoginButton() {
		return Login;
	}

	public boolean loginPageLogo() {
		return Logo.isDisplayed();
	}

	public WebElement loginsectioncolour() {
		return colour;

	}

	public void registerNewMembers(String username, String userpassword) {

		Username.sendKeys(username);
		UserPassword.sendKeys(userpassword);
	}
}
