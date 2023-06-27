package com.qa.rediff.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.rediff.base.Rediff_TestBase;
import com.qa.rediff.pages.Rediff_Linkstest_Page;

public class Rediff_Links_Test extends Rediff_TestBase {
	public Rediff_Links_Test() throws Exception {
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
	public void validateLinksPresentOnLandingPage() {
		Rediff_Linkstest_Page linksPage = new Rediff_Linkstest_Page(driver);
		linksPage.clickOnRediffMailLink();
        softassert.assertTrue(linksPage.rediffMailLogoIsDisplayed());
		driver.navigate().back();
		
		linksPage.clickOnRediffMoneyLink();
        softassert.assertTrue(linksPage.rediffMoneyLogoIsDisplayed());
		driver.navigate().back();
		
		linksPage.clickOnRediffBusinessMailLink();
        softassert.assertTrue(linksPage.rediffBusinessMailLogoIsDisplayed());
		driver.navigate().back();
		
		linksPage.clickOnRediffVideosLink();
        softassert.assertTrue(linksPage.rediffVideoLogoIsDisplayed());
		driver.navigate().back();
		
		linksPage.clickOnRediffShoppingLink();
		driver.findElement(By.cssSelector("a.shopicon.relative")).click();
		softassert.assertTrue(linksPage.rediffShoppingLogoIsDisplayed());
		driver.navigate().back();

		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
