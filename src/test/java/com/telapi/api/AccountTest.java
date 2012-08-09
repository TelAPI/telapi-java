package com.telapi.api;

import org.junit.Test;

import com.telapi.api.restproxies.AccountsProxy;

public class AccountTest extends BaseTelapiTest<AccountsProxy>{

	public AccountTest() {
		super(AccountsProxy.class);
	}

	@Test
	public void testGetAccount(){
		proxy.getAccount(conf.getSid()).getEntity();
		proxy.getAccounts().getEntity();
	}
	
}
