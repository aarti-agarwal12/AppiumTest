package dataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties config;
	private final String CONFIG_PROPERTIES = File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"config.properties";
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader (System.getProperty("user.dir")+ CONFIG_PROPERTIES));
			config = new Properties();
			try {
				config.load(reader);
				reader.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configure.properties is not found at "+config);
		}
	}
	
	public DriverType getBrowserType() {
		String browserType = config.getProperty("browserType");
		if(browserType==null || browserType.equals("android"))
			return DriverType.ANDROID;
		else
			throw new RuntimeException("browsertype is not supported");
	}
	
	public int getImplicitlyWait() {
		String implicitWait = config.getProperty("impicitlyWait");
		if(implicitWait!=null)
			return Integer.parseInt(implicitWait);
		else
			throw new RuntimeException("Implicit wait is not specified in config.properties");
	}
	
	public enum DriverType{
		ANDROID
	}
}

