package com.telapi.api;

import org.junit.Before;

import com.telapi.api.configuration.TelapiConfiguration;
import com.telapi.api.testutil.TestConnector;
import com.telapi.api.testutil.TestParameters;

public abstract class BaseTelapiTest<T> {
	
	protected T proxy;
	private Class<T> className;
	protected TelapiConfiguration conf;
	protected TestConnector conn;
	protected TestParameters testParameters;
	
	public BaseTelapiTest(Class<T> className){
		this.className = className;
		this.testParameters = new TestParameters();
	}
	
	@Before
	public void createProxy(){
		conn = new TestConnector();
		proxy = conn.createProxy(className);
		conf = conn.getConfiguration();
	}
	
}
