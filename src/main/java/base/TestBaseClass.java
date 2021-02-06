package base;

import java.io.File;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import dataProvider.ConfigFileReader;

public abstract class TestBaseClass {
	public static  WebDriver webDriver;
	protected  ConfigFileReader configFileReader;
	public static int ImplicitWaitTime;
	
	public static final String URL = "http://127.0.0.1:4723/wd/hub";
	File app = new File(System.getProperty("user.dir"), "Amazon_shopping.apk");
	public  void initialize() 
	{
		try {
			// checking for Web-driver instance and browser exist or not 
			if (webDriver == null || hasQuit(webDriver)) 
			{
				configFileReader = new ConfigFileReader();
				ImplicitWaitTime = configFileReader.getImplicitlyWait();
				createLocalDriver();
			}
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private WebDriver createLocalDriver() {
		
		switch(configFileReader.getBrowserType()) {
		case ANDROID:
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", "Android");
			caps.setCapability("deviceName", "One Plus");
			caps.setCapability("app", app.getAbsolutePath());
			caps.setCapability("appPackage", "in.amazon.mShop.android.shopping");
			caps.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
			try {
				webDriver = new RemoteWebDriver(new java.net.URL(URL), caps);
			} catch(MalformedURLException e) {
				e.printStackTrace();
			}
			break;
			
		default:
			break;
		}
		return webDriver;
	}

	/**
	 * this is to check that the browser is opened or not
	 * @param driver
	 * @return
	 */
	public static boolean hasQuit(WebDriver driver) 
	{
		try 
		{
			driver.getTitle();
			return false;
		} catch (Exception e) {
			return true;
		}
	}
}