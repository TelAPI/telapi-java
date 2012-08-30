package com.telapi.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.telapi.api.domain.CarrierLookup;
import com.telapi.api.domain.list.CnamDipList;
import com.telapi.api.restproxies.CarrierLookupProxy;

public class CarrierLookupTest extends BaseTelapiTest<CarrierLookupProxy>{

	public CarrierLookupTest() {
		super(CarrierLookupProxy.class);
	}
	
	@Test
	public void testCarrierLookup() {
		CarrierLookup lookup = proxy.carrierLookup(conf.getSid(), testParameters.getPhone1()).getEntity();
		System.out.println(lookup.getCarrier());
		
	}
	
	@Test
	public void testCnamLookup() {
		CnamDipList lookup = proxy.cnamLookup(conf.getSid(), testParameters.getPhone1()).getEntity();
		System.out.println(lookup.getTotal());
	}
	
	
	@Test
	public void testCnamLookupMany() {
		List<String> lookupNumbers = new ArrayList<String>();
		lookupNumbers.add(testParameters.getPhone1());
		lookupNumbers.add(testParameters.getPhone2());
		CnamDipList lookup = proxy.cnamLookup(conf.getSid(), lookupNumbers).getEntity();
		System.out.println(lookup.getTotal());
	}
	
}
