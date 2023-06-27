package com.qa.rediff.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.rediff.base.Rediff_TestBase;
import com.qa.rediff.pages.Rediff_Inboxtest_Page;

public class Rediff_Inboxpage_Test extends Rediff_TestBase {
	public Rediff_Inboxpage_Test() throws Exception {
		super();

	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		driver = launchAndInitializeBrowser(prop.getProperty("browser1"));
		Rediff_Inboxtest_Page inboxPage = new Rediff_Inboxtest_Page(driver);
		inboxPage.clickOnSignInLink();
		
	}

	@Test
	public void validateInboxPageWithInboxButtonDisplay() {
		Rediff_Inboxtest_Page inboxPage = new Rediff_Inboxtest_Page(driver);
		inboxPage.enterUserName(prop.getProperty("validUsername"));
		inboxPage.enterPassword(prop.getProperty("validPassword"));
		inboxPage.clickOnSignInButton();
		softassert.assertTrue(inboxPage.inboxButtonIsDisplayed()); 
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
