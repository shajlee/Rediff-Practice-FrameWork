package com.qa.rediff.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.rediff.base.Rediff_TestBase;
import com.qa.rediff.pages.Rediff_Logintest_Page;
import com.qa.rediff.testdata.Rediff_Supply_TestData;
import com.qa.rediff.utilities.Rediff_Utilities;

public class Rediff_Loginpage_Test extends Rediff_TestBase {
	public Rediff_Loginpage_Test() throws Exception {
		super();

	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		driver = launchAndInitializeBrowser(prop.getProperty("browser1"));
		Rediff_Logintest_Page loginPage = new Rediff_Logintest_Page(driver);
		loginPage.clickOnSignInLink();
		// driver.findElement(By.linkText("Sign in")).click();
	}

	@Test(priority = 1, dataProvider = "RediffDataProviderSupply", dataProviderClass = Rediff_Supply_TestData.class)
	public void loginWithValidCredentialsUsingDataProvider(String username, String password) {
		Rediff_Logintest_Page loginPage = new Rediff_Logintest_Page(driver);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickOnSignInButton();
		softassert.assertTrue(loginPage.inboxButtonIsDisplayed());
		softassert.assertAll();
	}

	//@Test(priority = 2, dataProvider = "RediffExcelData", dataProviderClass = Rediff_Supply_TestData.class)
	//public void loginWithValidCredentialsUsingExcelSheet(String username, String password) {
		//Rediff_Logintest_Page loginPage = new Rediff_Logintest_Page(driver);
		//loginPage.enterUserName(username);
		//loginPage.enterPassword(password);
		//loginPage.clickOnSignInButton();
		//softassert.assertTrue(loginPage.inboxButtonIsDisplayed());
		//softassert.assertAll();

	

	@Test(priority = 2)
	public void loginWithInValidCredentials() {
		Rediff_Logintest_Page loginPage = new Rediff_Logintest_Page(driver);
		loginPage.enterUserName(Rediff_Utilities.generateEmailWithTimeStamp());
		loginPage.enterPassword(Rediff_Utilities.generatePasswordWithTimeStamp());
		loginPage.clickOnSignInButton();
		softassert.assertTrue(loginPage.invalidCredentialsWarningIsDisplayed());
		softassert.assertAll();
	}

	@Test(priority = 3)
	public void loginWithValidUsernameInvalidPassword() {
		Rediff_Logintest_Page loginPage = new Rediff_Logintest_Page(driver);
		loginPage.enterUserName((prop.getProperty("validUsername")));
		loginPage.enterPassword(Rediff_Utilities.generatePasswordWithTimeStamp());
		loginPage.clickOnSignInButton();
		softassert.assertTrue(loginPage.invalidCredentialsWarningIsDisplayed());
		softassert.assertAll();
	}

	@Test(priority = 4)
	public void loginWithInvalidUsernameValidPassword() {
		Rediff_Logintest_Page loginPage = new Rediff_Logintest_Page(driver);
		loginPage.enterUserName(Rediff_Utilities.generateEmailWithTimeStamp());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnSignInButton();
		softassert.assertTrue(loginPage.invalidCredentialsWarningIsDisplayed());
		softassert.assertAll();
	}

	@Test(priority = 5)
	public void loginWithNoCredentials() {
		Rediff_Logintest_Page loginPage = new Rediff_Logintest_Page(driver);
		loginPage.clickOnSignInButton();

		Alert alert = driver.switchTo().alert();
		String actualAlertText = prop.getProperty("actualAlertText");
		String expectedAlertText = alert.getText();

		softassert.assertEquals(actualAlertText, expectedAlertText);
		if (actualAlertText.equals(expectedAlertText)) {
			alert.accept();
		} else {
			alert.dismiss();

		}
		softassert.assertAll();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
