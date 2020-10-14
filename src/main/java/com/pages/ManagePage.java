package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseTest;

public class ManagePage extends BaseTest {

	public WebDriver driver;

	public ManagePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy(xpath = "//button[@id='newButton']")
	@CacheLookup
	WebElement createNewCurrency;

	private @FindBy(xpath = "//div[@class='column']//div[@class='ui raised segment menuCard blue manage']")
	@CacheLookup
	WebElement manageOption;

	public WebElement clickCreateNewCurrency() {
		return createNewCurrency;
	}
	public WebElement clickmanageOption() {
		return manageOption;
	}



}
