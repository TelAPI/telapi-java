package com.telapi.api;

import org.junit.Test;

import com.telapi.api.exceptions.TelapiException;

public class FraudControlTest extends BaseTelapiTest {

	@Test
	public void testListFraudControlResources() throws TelapiException {
		connector.listFraudControlResources(0L, 15L);
	}
	
	@Test
	public void testBlockDestination() throws TelapiException {
		connector.blockDestination("US", true, true, true);
	}
	
	@Test
	public void testAuthorizeDestination() throws TelapiException {
		connector.authorizeDestination("US", true, true, true);
	}
	
	@Test
	public void testExtendDestination() throws TelapiException {
		connector.extendDestinationAuth("US", true, true, true);
	}
	
	@Test
	public void testWhitelistDestination() throws TelapiException {
		connector.whitelistDestination("US", true, true, true);
	}

}
