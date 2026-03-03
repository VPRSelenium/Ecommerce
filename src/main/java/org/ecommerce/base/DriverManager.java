package org.ecommerce.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class DriverManager  {
	
	private  static  Logger log = LogManager.getLogger(DriverManager.class);
	private static final ThreadLocal <WebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	
	public static void setDriver(WebDriver instance) 
	{
		
		try {
			if(getDriver()!=null)
			{
				log.warn("driver is already initalized");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("driver is already initalized"+e.getMessage());
		}
		driver.set(instance);
	}
	
	public static void removeDriver()
	{
		if(getDriver()!=null)
		
		 driver.remove();
	}
	

	
	
	

}
