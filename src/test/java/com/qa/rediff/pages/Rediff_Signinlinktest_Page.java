package com.qa.rediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rediff_Signinlinktest_Page {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement signInLink;
	
	public Rediff_Signinlinktest_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean signInLinkIsDisplayed() {
		boolean displayStatus = signInLink.isDisplayed();
		return displayStatus;
		
		}
	}


