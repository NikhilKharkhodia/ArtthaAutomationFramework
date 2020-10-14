package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseTest;

public class InvalidLoginPage extends BaseTest {

	public WebDriver driver;

	public InvalidLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy(xpath = "//div[@class='ui header blue errPgHeading paddingBottom20']") 
	@CacheLookup 
	WebElement invalidlogin;

	public WebElement invaliduserlogin() {
		return invalidlogin;
	}
}