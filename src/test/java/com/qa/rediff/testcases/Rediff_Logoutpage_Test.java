package com.qa.rediff.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
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

public class Rediff_Logoutpage_Test extends Rediff_TestBase {
	public Rediff_Logoutpage_Test() throws Exception {
		super();

	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		driver = launchAndInitializeBrowser(prop.getProperty("browser1"));
		driver.findElement(By.linkText("Sign in")).click();
	}

	@Test
	public void validateLogoutFuctionalityWithLogoutMessage() {
		driver.findElement(By.id("login1")).sendKeys(prop.getProperty("validUsername"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.className("signinbtn")).click();

		WebElement logoutButton = driver.findElement(By.className("rd_logout"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();

		softassert.assertTrue(driver.findElement(By.cssSelector("div.panel p")).isDisplayed());
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
