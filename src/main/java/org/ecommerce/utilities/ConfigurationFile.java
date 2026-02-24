package org.ecommerce.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;

public class ConfigurationFile {

	protected static Logger log = LogManager.getLogger(ConfigurationFile.class);

	private static Properties prop;

	public Properties getfile(Properties prop) {
		this.prop = prop;
		return prop;

	}

	@BeforeSuite
	public static Properties setFile() throws IOException {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("src\\main\\resources\\config.properties");
			prop.load(file);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error("File is not loaded" + e.getMessage());

		}
		return prop;

	}

}
