package com.telapi.api;

import org.junit.Test;

import com.telapi.api.domain.CarrierLookup;
import com.telapi.api.domain.CnamDip;
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
		CnamDip lookup = proxy.cnamLookup(conf.getSid(), testParameters.getPhone1()).getEntity();
		System.out.println(lookup.getBody());
		
	}

}
