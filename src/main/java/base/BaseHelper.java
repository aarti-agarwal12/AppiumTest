package base;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;

public class BaseHelper {
	public ConfigFileReader configFileReader;
	
	
	public BaseHelper() {
		configFileReader = new ConfigFileReader();
	}
	
	public WebElement getField (WebDriver webDriver,By by, String message)	{
		WebElement element = null;       
		try
		{
			element = webDriver.findElement(by);
		}
		catch(NoSuchElementException e)
		{
			element = null; 
		}
		catch(Exception e){
			fail(message + ": " + e.getMessage());
		}
		assertNotNull(message, element);
		return element;
	}
	
	public void fillTextFields(WebDriver webDriver, By field, String value, String fieldName, String page)
	{
		WebElement element = this.getField(webDriver, field, fieldName + " text box field not found on " + page + " page");
		element.clear();
		element.sendKeys(value);
	} 
}
