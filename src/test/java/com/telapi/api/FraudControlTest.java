package com.telapi.api;

import org.junit.Test;

import com.telapi.api.restproxies.FraudControlProxy;

public class FraudControlTest extends BaseTelapiTest<FraudControlProxy>{

	public FraudControlTest() {
		super(FraudControlProxy.class);
	}
	
	@Test
	public void testListFraudControlResources() {
		proxy.listFraudControlResources(conf.getSid(), null, null).getEntity();
	}
	
	@Test
	public void testAuthorizeDestination() {
		proxy.authorizeDestination(conf.getSid(), "HR", true, true, true).getEntity();
	}
	
	@Test
	public void testBlockDestination() {
		proxy.blockDestination(conf.getSid(), "HR", true, true, true).getEntity();
	}
	
	@Test
	public void testExtendDestination() {
		proxy.extendDestinationAuth(conf.getSid(), "HR", true, true, true).getEntity();
	}
	
	@Test
	public void testWhitelistDestination() {
		proxy.whitelistDestination(conf.getSid(), "HR", true, true, true).getEntity();
	}

}
