package com.telapi.api.testutil;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;

public class TestParameters extends Properties {
	private static final long serialVersionUID = -7348144965758395514L;
	Logger logger = Logger.getLogger(TestParameters.class);
	
	public TestParameters() {
		this("telapi.test.properties");
	}
	
	protected TestParameters(String propFileName) {
		URL url = ClassLoader.getSystemResource(propFileName);
		try {
			load(url.openStream());
		} catch (IOException e) {
			logger.error("Cannot load or find Telapi test properties file on classpath: "
					+ propFileName, e);
		}
	}

	public String getPhone1() {
		return getProperty("phone1");
	}
	
	public String getPhone2() {
		return getProperty("phone2");
	}
	
	public String getMp3Url() {
		return getProperty("mp3url");
	}
	
}
