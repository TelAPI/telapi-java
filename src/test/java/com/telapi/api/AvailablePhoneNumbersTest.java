package com.telapi.api;

import org.junit.Test;

import com.telapi.api.exceptions.TelapiException;

public class AvailablePhoneNumbersTest extends BaseTelapiTest {
	
	@Test
	public void testListAvailablePhoneNumbers() throws TelapiException{
		connector.listAvailablePhoneNumbers("US", "425", "999", "KS", "66101", 0L, 10L);
	}
}
