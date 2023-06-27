package com.qa.rediff.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.rediff.base.Rediff_TestBase;
import com.qa.rediff.pages.Rediff_Hometest_Page;

public class Rediff_Homepage_Test extends Rediff_TestBase {
	public Rediff_Homepage_Test() throws Exception {
		super();

	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		driver = launchAndInitializeBrowser(prop.getProperty("browser1"));
		Rediff_Hometest_Page homePage = new Rediff_Hometest_Page(driver);
		homePage.clickOnSignInLink();

	}

	@Test
	public void validityOfHomePageButton() {
		Rediff_Hometest_Page homePage = new Rediff_Hometest_Page(driver);
		homePage.enterUserName(prop.getProperty("validUsername"));
		homePage.enterPassword(prop.getProperty("validPassword"));
		homePage.clickOnSignInButton();

		WebElement logoutButton = homePage.logoutButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();

		WebElement rediffHomeButton = homePage.rediffHomeButton();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(rediffHomeButton)).click();

		softassert.assertTrue(homePage.rediffLogoIsDisplayed());
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
