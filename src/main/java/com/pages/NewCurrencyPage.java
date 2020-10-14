package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseTest;

public class NewCurrencyPage extends BaseTest {

	public WebDriver driver;

	public NewCurrencyPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy(xpath = "//input[@id='valuesname']")
	@CacheLookup
	WebElement currencyName;

	private @FindBy(xpath = "//input[@id='valuessymbol']")
	@CacheLookup
	WebElement symbol;

	private @FindBy(xpath = "//input[@id='descriptionText']")
	@CacheLookup
	WebElement description;
	

	private @FindBy(xpath = "//input[@id='saveButton']")
	@CacheLookup
	WebElement saveButton;
	

	private @FindBy(xpath = "//input[@id='valuesname']")
	@CacheLookup
	WebElement popup;
	
	public WebElement enterCurrencyName() {
		return currencyName;
	}
	public WebElement enterSymbol() {
		return symbol;
	}
	public WebElement enterdescription() {
		return description;
	}
	public WebElement entersaveButton() {
		return saveButton;
	}
	public WebElement clickonpopup() {
		return popup;
	}



}
