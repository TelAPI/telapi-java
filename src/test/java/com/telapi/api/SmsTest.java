package com.telapi.api;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.telapi.api.domain.SmsMessage;
import com.telapi.api.exceptions.TelapiException;


public class SmsTest extends BaseTelapiTest {

	@Test
	public void testGetSmsList() throws TelapiException{
		connector.listSmsMessages("1", "2", new Date(0), new Date(), 0L, 10L);
	}
	
	@Test
	public void testSendAndGetSms() throws TelapiException{
		SmsMessage msg = connector.sendSmsMessage(testParameters.getPhone1(), testParameters.getPhone2(), "test from java", "callback.url");
		SmsMessage receivedMessage = connector.viewSmsMessage(msg.getSid());
		Assert.assertEquals(msg.getSid(), receivedMessage.getSid());
	}
	
}
