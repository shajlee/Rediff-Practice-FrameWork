package com.qa.rediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rediff_Hometest_Page {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement signInLink;
	
	@FindBy(id = "login1")
	private WebElement usernameTextBox;
	
	@FindBy(id = "password")
	private WebElement passwordTextBox;
	
	@FindBy(className = "signinbtn")
	private WebElement signInButton;
	
	@FindBy(className = "rd_logout")
	private WebElement logoutButton;
	
	@FindBy(css = "div.header div a+span a+a b")
	private WebElement rediffHomeButton;
	
	@FindBy(css = "span.hmsprite.logo")
	private WebElement rediffLogo;
	
	public Rediff_Hometest_Page(WebDriver driver) {
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
	public WebElement logoutButton() {
		return logoutButton;
	}
	public WebElement rediffHomeButton() {
		return rediffHomeButton;
	}
	public boolean rediffLogoIsDisplayed() {
		boolean displayStatus = rediffLogo.isDisplayed();
		return displayStatus;
	

	}
	
}


