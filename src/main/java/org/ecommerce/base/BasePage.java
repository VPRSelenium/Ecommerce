package org.ecommerce.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage  {

	protected WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver = driver; // store driver for direct use
		PageFactory.initElements(driver, this);
	}
	
	
}
