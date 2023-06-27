package com.qa.rediff.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.qa.rediff.utilities.Rediff_Utilities;

public class Rediff_TestBase {
	public static WebDriver driver;
	public static ChromeOptions optionsC;
	public static FirefoxOptions optionsF;
	public static EdgeOptions optionsE;
	public static Properties prop;
	
	public Rediff_TestBase() throws Exception {
		prop = new Properties();
		FileInputStream Ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\rediff\\propertiesfiles\\configuration.properties");
		prop.load(Ip);
	}

	
	public WebDriver launchAndInitializeBrowser(String browserName) {
	if(browserName.equals(prop.getProperty("browser1"))) {
		optionsC = new ChromeOptions();
		optionsC.addArguments("--incognito");
		driver = new ChromeDriver(optionsC);
	}else if(browserName.equals(prop.getProperty("browser2"))) {
		optionsF = new FirefoxOptions();
		optionsF.addArguments("--incognito");
		driver = new FirefoxDriver(optionsF);
	}else if(browserName.equals(prop.getProperty("browser3"))) {
		optionsE = new EdgeOptions();
		optionsE.addArguments("--incognito");
		driver = new EdgeDriver(optionsE);
	}
	driver.manage().window().maximize();
	driver.get(prop.getProperty("url"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Rediff_Utilities.IMPLICIT_WAIT_TIME));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Rediff_Utilities.PAGELOAD_WAIT_TIME));
	driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Rediff_Utilities.SCRIPTLOAD_WAIT_TIME));
	driver.manage().deleteAllCookies();
	
	return driver;
		
		
	}
	
	

}


