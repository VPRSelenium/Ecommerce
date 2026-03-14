package org.ecommerce.utilities;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ecommerce.base.DriverManager;
import org.ecommerce.factorydriver.FactoryDriver;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsDriver  {

	protected FactoryDriver waits;
	protected static Logger log = LogManager.getLogger(ActionsDriver.class);

	public static void dragAndDrop(WebElement source, WebElement target) {

		try {
			if (FactoryDriver.actionDriver() != null) {
				FactoryDriver.actionDriver().dragAndDrop(source, target).perform();
				log.info("Action is successfully completed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Action  is not performed" + e.getMessage());
		}

	}

	public static void dragAndDropBy(WebElement source, int x, int y) {

		try {
			if (FactoryDriver.actionDriver() != null) {
				FactoryDriver.actionDriver().dragAndDropBy(source, x, y).perform();
				log.info("Action is successfully completed");
			}
		} catch (Exception e) {
			log.error("Action  is not performed" + e.getMessage());

		}

	}

	public static void doubleClick(WebElement element) {

		try {
			if (FactoryDriver.actionDriver() != null) {
				FactoryDriver.actionDriver().doubleClick(element).perform();
				log.info("Action is successfully completed");
			}
		} catch (Exception e) {
			log.error("Action  is not performed" + e.getMessage());

		}

	}

	// select
	public static void selectByValue(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void selectByIndex(WebElement element, int in) {

		Select select = new Select(element);
		select.selectByIndex(in);
	}
	
	//implicit wait
	
	public static void implic(int seconds)
	{
		try {
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Element is not intreacated " + e.getMessage());
		}
	}
	

// explicit wait
	public static void elementClickable(WebElement element) {
		try {

			FactoryDriver.webDriverWait(3).until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Element is not intreacated " + e.getMessage());
		}
	}

   public static void elementSelected(WebElement elementS)
   {
	   try
	   {
	   FactoryDriver.webDriverWait(3).until(ExpectedConditions.elementToBeSelected(elementS));
	   
	   }catch (Exception e)
	   
	   {
		   log.error("Element is not intreacated " + e.getMessage());
	   }
   }
		
   
  //fluent wait
   
   

//alert
	public static void simpleAlertAccept() {
		Alert alert = DriverManager.getDriver().switchTo().alert();
		alert.accept();

	}

//frame

	public static void selectByFrameIndex(int index) {
		DriverManager.getDriver().switchTo().frame(index);
	}

	public static void selectByFrameElement(WebElement element) {
		DriverManager.getDriver().switchTo().frame(element);
	}

	public static void selectByFrameName(String name) {
		DriverManager.getDriver().switchTo().frame(name);
	}

	public static void switchToDefault() {
		DriverManager.getDriver().switchTo().defaultContent();
	}

	public static void switchToParentFrame() {
		DriverManager.getDriver().switchTo().parentFrame();
	}

	// screenshot

	public static void Takescreenshot(String fileName) {
		TakesScreenshot ss = (TakesScreenshot) DriverManager.getDriver();
		File actual = ss.getScreenshotAs(OutputType.FILE);
		File ff = new File("src\\test\\resources\\screenshot/" + fileName + ".png");
		try {
			FileUtils.copyFile(actual, ff);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.warn("Failed to save screenshot: " + e.getMessage());
		}
	}
	// javascriptexecutor

	public static void clickElement(WebElement element) {
		try {
			FactoryDriver.javascript().executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("driver is not initalizer" + e.getMessage());
		}

	}

	public static void scrollDown(WebElement element) {
		try {
			FactoryDriver.javascript().executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("driver is not initalizer" + e.getMessage());
		}

	}

	public static void scrollDownToTitle(WebElement element) {
		try {

			FactoryDriver.javascript().executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("driver is not initalizer" + e.getMessage());
		}

	}

	public static void jsSendKeys(WebElement element) {

		try {

			FactoryDriver.javascript().executeScript("arguments[0].value='value';", element);

		} catch (Exception e) {
			log.error("driver is not initalizer" + e.getMessage());

		}

	}

	// windows handling
	public static void switchingSingleWindow() {
		String Parent = DriverManager.getDriver().getWindowHandle();
		DriverManager.getDriver().switchTo().window(Parent);
	}

	public static void switchingfirstWindows() {
		String parent = DriverManager.getDriver().getWindowHandle(); // store parent window
		Set<String> allwindows = DriverManager.getDriver().getWindowHandles();

		for (String child : allwindows) {
			try {
				if (!child.equals(parent)) {
					DriverManager.getDriver().switchTo().window(child);
					break;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error("it  is in parent window" + e.getMessage());
			}

		}

	}

	public static  void switchByTitle(String expectedTitle) {
		String Parent = DriverManager.getDriver().getWindowHandle();
		Set<String> AllWindows = DriverManager.getDriver().getWindowHandles();

		for (String child : AllWindows) {
			DriverManager.getDriver().switchTo().window(child);
			if (DriverManager.getDriver().getTitle().equals(expectedTitle)) {
				log.info("child window is found" + expectedTitle);
				break;
			}
		}

	}

	// robot class
	public static void selectAll() throws AWTException {

		FactoryDriver.robotDriver().keyPress(KeyEvent.VK_CONTROL);
		FactoryDriver.robotDriver().keyPress(KeyEvent.VK_A);

		FactoryDriver.robotDriver().keyRelease(KeyEvent.VK_A);
		FactoryDriver.robotDriver().keyRelease(KeyEvent.VK_CONTROL);

	}

	public static void copy() throws AWTException {
		FactoryDriver.robotDriver().keyPress(KeyEvent.VK_CONTROL);
		FactoryDriver.robotDriver().keyPress(KeyEvent.VK_C);

		FactoryDriver.robotDriver().keyRelease(KeyEvent.VK_C);
		FactoryDriver.robotDriver().keyRelease(KeyEvent.VK_CONTROL);

	}

	public static void nextField() throws AWTException {
		FactoryDriver.robotDriver().keyPress(KeyEvent.VK_TAB);
		FactoryDriver.robotDriver().keyRelease(KeyEvent.VK_TAB);

	}

	public static void paste() throws AWTException {
		FactoryDriver.robotDriver().keyPress(KeyEvent.VK_CONTROL);
		FactoryDriver.robotDriver().keyPress(KeyEvent.VK_V);

		FactoryDriver.robotDriver().keyRelease(KeyEvent.VK_V);
		FactoryDriver.robotDriver().keyRelease(KeyEvent.VK_CONTROL);
	}

	public static String getElementsDetails(WebElement element) {

		if (element == null) {
			return "element is null";
		}

		String name = element.getDomAttribute("name");
		String id = element.getDomAttribute("id");
		String placeholder = element.getDomAttribute("placeholder");
		String type = element.getDomAttribute("type");

		if (name != null && !name.isEmpty()) {
			return name;
		} else if (id != null && !id.isEmpty()) {

			return id;
		} else if (placeholder != null && !placeholder.isEmpty()) {

			return placeholder;
		} else if (type != null && !placeholder.isEmpty()) {

			return type;

		} else {
			return null;
		}

	}

	public static void sendKeys(WebElement element, String value) {
		log.info("Attribute value of the element is " + getElementsDetails(element));
		element.sendKeys(value);
	}

	public static void click(WebElement element) {
		try {
			log.info("Attribute value of the element is " + getElementsDetails(element));
			element.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("Element is not clickable" + e.getMessage());
		}
	}
	
	
	public static String captureScreenshot(String filename) throws IOException
	{
		
		File source = FactoryDriver.screenshot().getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir" + "/screenshot/" + filename + "jpeg");
		File target = new File(path);
		FileUtils.copyFile(source, target);
		return path;
	
	
	}

	

//


	
}



//implcit


