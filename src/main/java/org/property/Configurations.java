package org.property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurations {
	public static String propertyFileReader(String property) {
		Properties prop= new Properties();
		try(FileInputStream file = new FileInputStream("F:\\logical\\src\\main\\resources\\config.properties"))
		{		
			prop.load(file);
		}catch (IOException e) {
			System.out.println("Unable to find the property files");
		}
		return prop.getProperty(property);
	}

}
