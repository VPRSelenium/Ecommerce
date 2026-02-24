package org.ecommerce.factorydriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.ecommerce.base.BaseTest;
import org.ecommerce.base.DriverManager;
import org.ecommerce.utilities.ConfigurationFile;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class FactoryDriver {

	protected static Logger log = LogManager.getLogger(FactoryDriver.class);

	
	
	
	@Parameters("browser")
	public static void browserDriver(@Optional String browser) throws IOException {

		if (browser == null || browser.isEmpty()) {
			browser = ConfigurationFile.setFile().getProperty("browser");
		}

		try {

			if (browser.equalsIgnoreCase("chrome")) {
				DriverManager.setDriver(new ChromeDriver());
		 
			}

			else if (browser.equalsIgnoreCase("firefox")) {
				DriverManager.setDriver(new FirefoxDriver());
			} else if (browser.equalsIgnoreCase("edge")) {
				DriverManager.setDriver(new EdgeDriver());
			} else {

			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Failed to intitalize BrowserDriver: " + e.getMessage());
		}
	}
	
	public static TakesScreenshot screenshot()
	{
		TakesScreenshot screenshot=(TakesScreenshot)DriverManager.getDriver();
		return screenshot;
	}
	
	
	
	public static Actions actionDriver() {

		return new Actions(DriverManager.getDriver());
	}

	public static WebDriverWait webDriverWait(int time) {

		return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(time));

	}

	public static Robot robotDriver() throws AWTException {

		try {
			return new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			log.error("Failed to initalize Robot Driver", e);
			return null;
		}

	}

	public static JavascriptExecutor javascript() {
		return (JavascriptExecutor) DriverManager.getDriver();
	}

}

//factorydriver -common object creation
//base class- browser setup and termination
//action class- all the action methods 
//log4j
//to get elements details
//pom 
