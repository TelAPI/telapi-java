package com.telapi.api;

import com.telapi.api.configuration.PropertiesFileTelapiConfiguration;
import com.telapi.api.configuration.TelapiConfiguration;
import com.telapi.api.testutil.TestParameters;

public abstract class BaseTelapiTest {
	
	protected TelapiConfiguration conf;
	protected TestParameters testParameters;
	protected TelapiConnector connector;
	
	public BaseTelapiTest(){
		this.testParameters = new TestParameters();
		conf = new PropertiesFileTelapiConfiguration();
		connector = new TelapiConnector(conf);
	}
	
}
