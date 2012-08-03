package com.telapi.api;

import junit.framework.Assert;

import org.junit.Test;

import com.telapi.api.configuration.PropertiesFileTelapiConfiguration;
import com.telapi.api.domain.Account;
import com.telapi.api.domain.list.AccountsList;
import com.telapi.api.exceptions.TelapiException;

public class AccountTest {

	@Test
	public void testGetAccount(){
		PropertiesFileTelapiConfiguration conf = new PropertiesFileTelapiConfiguration();
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			conn.getAccount();
			AccountsList list = conn.getAccounts();
			for(Account acc : list) {
				System.out.println(acc.getSid());
			}
		} catch (TelapiException e) {
			Assert.fail();
		}
	}
	
}
