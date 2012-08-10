package com.telapi.api;

import junit.framework.Assert;

import org.junit.Test;

import com.telapi.api.domain.IncomingPhoneNumber;
import com.telapi.api.domain.list.IncomingPhoneNumberList;
import com.telapi.api.restproxies.IncomingPhoneNumberProxy;

public class IncomingPhoneNumberTest extends BaseTelapiTest<IncomingPhoneNumberProxy>{

	public IncomingPhoneNumberTest() {
		super(IncomingPhoneNumberProxy.class);
	}
	
	@Test
	public void testListPhoneNumbers() {
		IncomingPhoneNumberList list = proxy.listIncomingPhoneNumbers(conf.getSid(), null, null, null, null).getEntity();
		for(IncomingPhoneNumber number : list) {
			System.out.println(number.getPhoneNumber());
		}
	}
	
	public void testViewPhoneNumber() {
		IncomingPhoneNumberList list = proxy.listIncomingPhoneNumbers(conf.getSid(), null, null, null, null).getEntity();
		for(IncomingPhoneNumber number : list) {
			proxy.viewIncomingPhoneNumber(conf.getSid(), number.getSid()).getEntity();
		}
	}
	
	@Test
	public void addPhoneNumbers() {
		proxy.addIncomingPhoneNumber(conf.getSid(), testParameters.getPhone1(), testParameters.getArea1()).getEntity();
		proxy.addIncomingPhoneNumber(conf.getSid(), testParameters.getPhone2(), testParameters.getArea2()).getEntity();
	}
	
	@Test
	public void testDeleteAndAddPhoneNumber() {
		
		IncomingPhoneNumberList list = proxy.listIncomingPhoneNumbers(conf.getSid(), null, null, null, null).getEntity();
		IncomingPhoneNumber number = list.iterator().next();
		
		proxy.deleteIncomingPhoneNumber(conf.getSid(), number.getSid()).getEntity();
		
		list = proxy.listIncomingPhoneNumbers(conf.getSid(), null, null, null, null).getEntity();
		for(IncomingPhoneNumber lNumber : list) {
			if (lNumber.getSid().equals(number.getSid())) {
				Assert.fail("Number wasn't deleted!");
				return;
			}
		}
		
		String prefix = number.getPhoneNumber().substring(0, 5);
		proxy.addIncomingPhoneNumber(conf.getSid(), number.getPhoneNumber(), prefix).getEntity();
		
	}
	
	@Test
	public void testUpdateNumber(){
		IncomingPhoneNumberList list = proxy.listIncomingPhoneNumbers(conf.getSid(), null, null, null, null).getEntity();
		IncomingPhoneNumber number = list.iterator().next();
		proxy.updateIncomingPhoneNumber(conf.getSid(), number.getSid(), "first_number", 
				"voice.com", null, null, null, null, null, null, null, null, null, null).getEntity();
		IncomingPhoneNumber nr = proxy.viewIncomingPhoneNumber(conf.getSid(), number.getSid()).getEntity();
		Assert.assertEquals("voice.com", nr.getVoiceUrl().trim());
		
		proxy.updateIncomingPhoneNumber(conf.getSid(), number.getSid(), null, 
				"", null, null, null, null, null, null, null, null, null, null).getEntity();
		nr = proxy.viewIncomingPhoneNumber(conf.getSid(), number.getSid()).getEntity();
		Assert.assertEquals("", nr.getVoiceUrl().trim());
		
	}
	
}
