package com.qa.rediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rediff_Inboxtest_Page {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement signInLink;
	
	@FindBy(id = "login1")
	private WebElement usernameTextBox;
	
	@FindBy(id = "password")
	private WebElement passwordTextBox;
	
	@FindBy(className = "signinbtn")
	private WebElement signInButton;
	
	@FindBy(css = "a.rd_active")
	private WebElement inboxButton;
	
	public Rediff_Inboxtest_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSignInLink() {
		signInLink.click();
	}
	
	public void enterUserName(String userNameText) {
		usernameTextBox.sendKeys(userNameText);
	}
	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	
	public void clickOnSignInButton() {
		signInButton.click();
	}
	
	public boolean inboxButtonIsDisplayed() {
		boolean displayStatus = inboxButton.isDisplayed();
		return displayStatus;
		
	}

}
