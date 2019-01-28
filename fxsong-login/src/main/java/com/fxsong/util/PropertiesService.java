package com.fxsong.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesService {
	
	private static Properties properties;

	public static String getProperty(String key) throws IOException{
		if (properties == null){
			properties = getProperties();
		}
		return properties.getProperty(key);
	}

	private static Properties getProperties() throws IOException{
		Properties properties = new Properties();
		FileInputStream inStream = new FileInputStream(new File("/temp/test.properties"));
		properties.load(inStream);
		inStream.close();
		return properties;
	}

}
