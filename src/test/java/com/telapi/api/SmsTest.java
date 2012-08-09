package com.telapi.api;

import junit.framework.Assert;

import org.junit.Test;

import com.telapi.api.domain.SmsMessage;
import com.telapi.api.restproxies.SmsProxy;


public class SmsTest extends BaseTelapiTest<SmsProxy>{
	
	public SmsTest() {
		super(SmsProxy.class);
	}
	
	@Test
	public void testGetSmsList(){
		proxy.getSmsMessageList(conf.getSid(), null, null, null, null, null, null).getEntity();
	}
	
	@Test
	public void testSendAndGetSms(){
		SmsMessage msg = proxy.sendSmsMessage(conf.getSid(), testParameters.getPhone1(), testParameters.getPhone2(), "test from java", null).getEntity();
		SmsMessage receivedMessage = proxy.getSmsMessage(conf.getSid(), msg.getSid()).getEntity();
		Assert.assertEquals(msg.getSid(), receivedMessage.getSid());
	}
	
}
