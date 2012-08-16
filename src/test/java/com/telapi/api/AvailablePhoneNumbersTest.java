package com.telapi.api;

import org.junit.Test;

import com.telapi.api.restproxies.AvailablePhoneNumberProxy;

public class AvailablePhoneNumbersTest extends BaseTelapiTest<AvailablePhoneNumberProxy>{
	
	public AvailablePhoneNumbersTest() {
		super(AvailablePhoneNumberProxy.class);
	}
	
	@Test
	public void testListAvailablePhoneNumbers(){
		proxy.listAvailablePhoneNumbers(conf.getSid(), "US", "425", "999", "KS", "66101").getEntity();
	}
}
