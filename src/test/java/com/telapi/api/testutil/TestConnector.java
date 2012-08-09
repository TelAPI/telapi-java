package com.telapi.api.testutil;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;

import com.telapi.api.configuration.DefaultTelapiConfiguration;
import com.telapi.api.configuration.PropertiesFileTelapiConfiguration;
import com.telapi.api.configuration.TelapiConfiguration;
import com.telapi.api.http.RestExecutor;

public class TestConnector {
	private ApacheHttpClient4Executor executor;
	private String fullBaseUrl;		
	private TelapiConfiguration conf;
	
	public TestConnector() {
		conf = new PropertiesFileTelapiConfiguration();
		executor = RestExecutor.createExecutor(conf);
		URI baseUrl = UriBuilder.fromUri(conf.getBaseUrl()).path(DefaultTelapiConfiguration.API_VERSION).build();
		fullBaseUrl = baseUrl.toString();
	}
	
	public <T> T createProxy(Class<T> clazz) {
		return ProxyFactory.create(clazz, fullBaseUrl, executor);
	}
	
	public TelapiConfiguration getConfiguration() {
		return conf;
	}

}

