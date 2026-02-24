package org.ecommerce.base;

import java.awt.AWTException;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.ecommerce.factorydriver.FactoryDriver;
import org.ecommerce.pom.LoginPage;
import org.ecommerce.utilities.ConfigurationFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import net.bytebuddy.implementation.bytecode.Throw;

public class BaseTest {

	protected WebDriver driver;

//	protected FactoryDriver dri;
	protected Logger logger = LogManager.getLogger(BaseTest.class);

	// LoginPage loginPage;

	@BeforeMethod(alwaysRun = true)
	public void browserStartUp() throws IOException {
		FactoryDriver.browserDriver(null);
		browserInitalize();
	}

	@AfterMethod(alwaysRun = true)
	public void browserTerminate() {
		try {
			if (DriverManager.getDriver() != null) {
				DriverManager.getDriver().quit();
				DriverManager.removeDriver();
				logger.info("Driver is sucessfully closed");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.warn("Driver is already null, nothing to quit.");
		}

	}

	public void browserInitalize() throws IOException {
		DriverManager.getDriver().get(ConfigurationFile.setFile().getProperty("Url"));
		DriverManager.getDriver().manage().window().maximize();
		FactoryDriver.webDriverWait(3);
		FactoryDriver.actionDriver();
		FactoryDriver.javascript();
		logger.info("All the Driver Actions is successfully initalized ");
	}

}

//error handling 
//null check
