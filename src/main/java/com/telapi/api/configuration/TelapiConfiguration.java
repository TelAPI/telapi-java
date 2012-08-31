package com.telapi.api.configuration;

/**
 * The basic interface which must return the Telapi configuration parameters.
 *
 */
public interface TelapiConfiguration {
	/**
	 * 
	 * @return The account Sid.
	 */
	public String getSid();
	/**
	 * 
	 * @return The authorization token.
	 */
	public String getAuthToken();
	
	/**
	 * 
	 * @return The base URL. This should be "https://api.telapi.com/" by default.
	 */
	public String getBaseUrl();
	
	/**
	 * 
	 * @return The proxy host (e.g. "192.168.0.1"). Leave null or empty if no proxy is to be used.
	 */
	public String getProxyHost();
	
	/**
	 * 
	 * @return The proxy port (e.g. 8080). Ignored if no proxy host is set.
	 */
	public String getProxyPort();
	
	/**
	 * 
	 * @return The proxy protocol (e.g. "http"). Ignored if no proxy host is set.
	 */
	public String getProxyProtocol();
}
