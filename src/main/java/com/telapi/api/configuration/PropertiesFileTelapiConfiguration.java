package com.telapi.api.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesFileTelapiConfiguration extends Properties implements TelapiConfiguration {
	private static final long serialVersionUID = -7348144965758395514L;
	Logger logger = Logger.getLogger(PropertiesFileTelapiConfiguration.class);
	
	public PropertiesFileTelapiConfiguration() {
		this("telapi.properties");
	}
	
	public PropertiesFileTelapiConfiguration(String propFileName) {
		URL url = ClassLoader.getSystemResource(propFileName);
		try {
			load(url.openStream());
		} catch (IOException e) {
			logger.error("Cannot load or find Telapi properties file on classpath: "
					+ propFileName, e);
		}
	}
	
	public PropertiesFileTelapiConfiguration(FileInputStream is) {
		try {
			load(is);
		} catch (IOException e) {
			logger.error("Cannot load the specified Telapi properties file.");
		}
	}

	@Override
	public String getSid() {
		return getProperty("sid");
	}

	@Override
	public String getAuthToken() {
		return getProperty("authToken");
	}

	@Override
	public String getBaseUrl() {
		return getProperty("baseUrl", DefaultTelapiConfiguration.BASE_URL);
	}
	
	

}
