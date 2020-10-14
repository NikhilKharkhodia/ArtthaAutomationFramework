package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseTest;

public class HomePage extends BaseTest {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy(xpath = "//a[@class='item iconLogo']")
	@CacheLookup
	WebElement welcometag;

	private @FindBy(xpath = "//div[@class='column']//div[@class='ui raised segment menuCard blue manage']")
	@CacheLookup
	WebElement manageOption;

	public WebElement welcomeuser() {
		return welcometag;
	}
	public WebElement clickmanageOption() {
		return manageOption;
	}



}
