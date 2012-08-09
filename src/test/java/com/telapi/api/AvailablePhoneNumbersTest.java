package com.telapi.api;

import org.junit.Test;

import com.telapi.api.restproxies.AvailablePhoneNumberProxy;

public class AvailablePhoneNumbersTest extends BaseTelapiTest<AvailablePhoneNumberProxy>{
	
	public AvailablePhoneNumbersTest() {
		super(AvailablePhoneNumberProxy.class);
	}
	
	@Test
	public void testListAvailablePhoneNumbers(){
		proxy.listAvailablePhoneNumbers(conf.getSid(), "US", "420", "7", "US", "90210").getEntity();
	}
}
