package com.telapi.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.telapi.api.domain.list.CarrierLookupList;
import com.telapi.api.domain.list.CnamDipList;
import com.telapi.api.exceptions.TelapiException;

public class CarrierLookupTest extends BaseTelapiTest {
	
	@Test
	public void testCarrierLookup() throws TelapiException {
		CarrierLookupList lookuplist = connector.carrierLookup(testParameters.getPhone1());
		System.out.println(lookuplist.getTotal());
		
	}
	
	@Test
	public void testCnamLookup() throws TelapiException {
		CnamDipList lookup = connector.cnamLookup(testParameters.getPhone1());
		System.out.println(lookup.getTotal());
	}
	
	
	@Test
	public void testCnamLookupMany() throws TelapiException {
		List<String> lookupNumbers = new ArrayList<String>();
		lookupNumbers.add(testParameters.getPhone1());
		lookupNumbers.add(testParameters.getPhone2());
		CnamDipList lookup = connector.cnamLookup(lookupNumbers);
		System.out.println(lookup.getTotal());
	}
	
}
