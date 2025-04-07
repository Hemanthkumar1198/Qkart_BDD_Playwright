package utils;

import java.io.FileInputStream;

import java.util.Properties;

public class ConfigProperties {

	private static Properties prop = new Properties();
	static {
		try {
			FileInputStream fs = new FileInputStream(".\\src\\test\\resources\\Config.properties");
			prop.load(fs);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static String getProperties(String key) {
		return prop.getProperty(key);
	}

}
