package com.telapi.api.configuration;

public class BasicTelapiConfiguration implements TelapiConfiguration {

	private String sid;
	private String authToken;
	private String baseUrl = DefaultTelapiConfiguration.BASE_URL;
	
	public BasicTelapiConfiguration() {
		
	}
	
	public BasicTelapiConfiguration(String sid, String authToken) {
		setSid(sid);
		setAuthToken(authToken);
	}
	
	@Override
	public String getSid() {
		return sid;
	}

	@Override
	public String getAuthToken() {
		return authToken;
	}

	@Override
	public String getBaseUrl() {
		return baseUrl;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

}
