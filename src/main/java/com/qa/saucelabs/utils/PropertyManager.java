package com.qa.saucelabs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
	private static String propertiesFilePath = "src" + File.separator + "test" + File.separator + "resources" + File.separator
			+ "config.properties";
	private static Properties props = new Properties();
	
	public static Properties getProps() {
		try {
			FileInputStream finp = new FileInputStream(propertiesFilePath);
			try {
				props.load(finp);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return props;
	}

}
