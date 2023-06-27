package com.qa.rediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rediff_Landingtest_Page {
	public WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	private WebElement signInLink;
	
	@FindBy(css = "span.hmsprite.logo")
	private WebElement rediffLogo;
	
	public Rediff_Landingtest_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean signInLinkIsDisplayed() {
		boolean displayStatus = signInLink.isDisplayed();
		return displayStatus;
	}
	public boolean rediffLogoIsDisplayed() {
		boolean displayStatus = rediffLogo.isDisplayed();
		return displayStatus;
				
	}

}
