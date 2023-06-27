package com.qa.rediff.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.rediff.base.Rediff_TestBase;
import com.qa.rediff.pages.Rediff_Signinlinktest_Page;

public class Rediff_SignInLink_Test extends Rediff_TestBase {
	public Rediff_SignInLink_Test() throws Exception {
		super();

	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		driver = launchAndInitializeBrowser(prop.getProperty("browser1"));

	}

	@Test
	public void presenceofSignInLink() {
		Rediff_Signinlinktest_Page signInLink = new Rediff_Signinlinktest_Page(driver);
		softassert.assertTrue(signInLink.signInLinkIsDisplayed()); 
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
