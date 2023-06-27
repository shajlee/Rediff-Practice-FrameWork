package com.qa.rediff.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.rediff.base.Rediff_TestBase;
import com.qa.rediff.pages.Rediff_Landingtest_Page;

public class Rediff_Landingpage_Test extends Rediff_TestBase {
	public Rediff_Landingpage_Test() throws Exception {
		super();

	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		driver = launchAndInitializeBrowser(prop.getProperty("browser1"));

	}

	@Test(priority = 1)
	public void validateTitleAndCurrentUrl() {
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		String actualTitle = prop.getProperty("actualTitle");
		String expectedTitle = driver.getTitle();

		String actualUrl = prop.getProperty("actualCurrentUrl");
		String expectedUrl = driver.getCurrentUrl();

		if (actualTitle.equals(expectedTitle) && actualUrl.equals(expectedUrl)) {
			System.out.println(prop.getProperty("landingPageValidityMessage"));
		} else {
			System.out.println(prop.getProperty("landingPageInValidityMessage"));
		}
	}

	@Test(priority = 2)
	public void presenceOfSignInLink() {
		Rediff_Landingtest_Page landingPage = new Rediff_Landingtest_Page(driver);
		softassert.assertTrue(landingPage.signInLinkIsDisplayed()); 
		softassert.assertAll();
		
	}

	@Test(priority = 3)
	public void presenceofRediffLogo() {
		Rediff_Landingtest_Page landingPage = new Rediff_Landingtest_Page(driver);
		softassert.assertTrue(landingPage.rediffLogoIsDisplayed()); 
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}

