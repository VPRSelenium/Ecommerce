package org.ecommerce.pom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ecommerce.base.BasePage;
import org.ecommerce.base.BaseTest;
import org.ecommerce.base.DriverManager;
import org.ecommerce.utilities.ActionsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	
	
	
	protected Logger log = LogManager.getLogger(LoginPage.class);

	@FindBy(id = "user-name")
	private WebElement uname;

	@FindBy(id = "password")
	private WebElement pass;

	@FindBy(id = "login-button")
	private WebElement loginButton;
	
	
	
	public  LoginPage(WebDriver driver)
	{
		super(driver);
	}

	/*
	public LoginPage()
	{
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
*/
	public void loginCredentials(String UserName, String Password) {

		log.debug(ActionsDriver.getElementsDetails(uname));
		ActionsDriver.sendKeys(uname, UserName);
		log.debug("UserName  is entered ");

		log.debug(ActionsDriver.getElementsDetails(pass));
		ActionsDriver.sendKeys(pass, Password);
		log.debug("Password is entered");

		log.debug(ActionsDriver.getElementsDetails(loginButton));
		ActionsDriver.click(loginButton);
		log.debug("Loginbutton is clicked and  login successful ");

		log.info("TestCase is completed for :" + getClass().getSimpleName());

		
		
		
	}

}

//
//LEVELS OF LOG

/*
 * ->TRACE ->DEBUG ->INFO ->WARN ->ERROR ->FATAL
 */
