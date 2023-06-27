package com.qa.rediff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rediff_Linkstest_Page {
	public WebDriver driver;
	
	@FindBy(className = "mailicon")
	private WebElement rediffMailLink;
	
	@FindBy(css = "div.logtext")
	private WebElement rediffMailLogo;
	
	@FindBy(css = "a.moneyicon.relative")
	private WebElement moneyLink;
	
	@FindBy(xpath = "//span[text()='Rediff Moneywiz']")
	private WebElement rediffMoneyWizLogo;
	
	@FindBy(css = "a.bmailicon.relative")
	private WebElement businessEmailLink;
	
	@FindBy(css = "a.logo img")
	private WebElement rediffBusinessMailLogo;
	
	@FindBy(className = "vdicon")
	private WebElement videosLink;
	
	@FindBy(css = "img.othersprite.isharelogo")
	private WebElement rediffVideoLogo;
	
	@FindBy(css = "a.shopicon.relative")
	private WebElement shoppingLink;
	
	@FindBy(css = "img.shsprite.shoptoplogo")
	private WebElement rediffShoppingLogo;
	
	public Rediff_Linkstest_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnRediffMailLink() {
		rediffMailLink.click();
	}
	public boolean rediffMailLogoIsDisplayed() {
		boolean displayStatus = rediffMailLogo.isDisplayed();
		return displayStatus;
	}
	public void clickOnRediffMoneyLink() {
		moneyLink.click();
	}
	public boolean rediffMoneyLogoIsDisplayed() {
		boolean displayStatus = rediffMoneyWizLogo.isDisplayed();
		return displayStatus;
	}
	public void clickOnRediffBusinessMailLink() {
		businessEmailLink.click();
	}
	public boolean rediffBusinessMailLogoIsDisplayed() {
		boolean displayStatus = rediffBusinessMailLogo.isDisplayed();
		return displayStatus;
	}
	public void clickOnRediffVideosLink() {
		videosLink.click();
	}
	public boolean rediffVideoLogoIsDisplayed() {
		boolean displayStatus = rediffVideoLogo.isDisplayed();
		return displayStatus;
	}
	public void clickOnRediffShoppingLink() {
		shoppingLink.isDisplayed();
	}
	public boolean rediffShoppingLogoIsDisplayed() {
		boolean displayStatus = rediffShoppingLogo.isDisplayed();
		return displayStatus;
	}

}
