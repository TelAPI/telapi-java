package com.telapi.api;

import junit.framework.Assert;

import org.junit.Test;

import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.configuration.PropertiesFileTelapiConfiguration;
import com.telapi.api.exceptions.TelapiException;

public class ConnectionTest {

	@Test
	public void testInvalidCredentials(){
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration("", "");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			conn.getAccount(new PropertiesFileTelapiConfiguration().getSid());
			Assert.fail();
		} catch (TelapiException e) {

		}
	}
	
}
