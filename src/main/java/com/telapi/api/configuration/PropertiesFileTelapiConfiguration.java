package com.telapi.api.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * A TelapiConfiguration implementation which loads the configuration from a file.
 * @see TelapiConfiguration
 *
 */
public class PropertiesFileTelapiConfiguration extends Properties implements TelapiConfiguration {
	private static final long serialVersionUID = -7348144965758395514L;
	Logger logger = Logger.getLogger(PropertiesFileTelapiConfiguration.class);
	
	/**
	 * Creates a TelapiConfiguration from a file called "telapi.properties" which must be on the classpath.
	 */
	public PropertiesFileTelapiConfiguration() {
		this("telapi.properties");
	}
	
	/**
	 * Creates a TelapiConfiguration from a file which must be on the classpath.
	 * @param propFileName The fileName of the properties file.
	 */
	public PropertiesFileTelapiConfiguration(String propFileName) {
		URL url = ClassLoader.getSystemResource(propFileName);
		try {
			load(url.openStream());
		} catch (IOException e) {
			logger.error("Cannot load or find Telapi properties file on classpath: "
					+ propFileName, e);
		}
	}
	
	/**
	 * Creates a TelapiConfiguration by loading properties from the provided FileInputStream.
	 * @param is The FileInputStream from which to load the configuration.
	 */
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
		return getProperty("baseUrl", TelapiConstants.BASE_URL);
	}

	@Override
	public String getProxyHost() {
		return getProperty("proxyHost", null);
	}

	@Override
	public String getProxyPort() {
		return getProperty("proxyPort", null);
	}

	@Override
	public String getProxyProtocol() {
		return getProperty("proxyProtocol", null);
	}
	
	

}
