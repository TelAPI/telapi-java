package com.telapi.api;

import org.junit.Test;

import com.telapi.api.exceptions.TelapiException;

public class AccountTest extends BaseTelapiTest{
	
	@Test
	public void testGetAccount() throws TelapiException{
		connector.viewAccount(conf.getSid());
		connector.viewAccounts();
	}
	
}
