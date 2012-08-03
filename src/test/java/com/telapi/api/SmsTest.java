package com.telapi.api;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import com.telapi.api.configuration.PropertiesFileTelapiConfiguration;
import com.telapi.api.domain.SmsMessage;
import com.telapi.api.domain.list.SmsMessageList;
import com.telapi.api.exceptions.TelapiException;


public class SmsTest {
	
	PropertiesFileTelapiConfiguration tc = new PropertiesFileTelapiConfiguration();
	
	@Test
	public void testGetSmsList(){
		
		TelapiConnector telc = new TelapiConnector(tc);
		try {
			SmsMessageList list = telc.getSmsMessageList(null, null, null, null, null, null);
			
			for (SmsMessage msg : list) {
				System.out.println(msg.getDateSent());
				System.out.println(msg.getStatus());
				System.out.println(msg.getDirection());
			}
		} catch (TelapiException ex) {
			ex.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	@Ignore
	public void testSendAndGetSms(){
		TelapiConnector telc = new TelapiConnector(tc);
		try {
			SmsMessage msg = telc.sendSmsMessage("(224) 632-1739", "(224) 632-1739", "test from java", null);
			SmsMessage receivedMessage = telc.getSmsMessage(msg.getSid());
			Assert.assertEquals(msg.getSid(), receivedMessage.getSid());
		} catch (TelapiException ex) {
			ex.printStackTrace();
			Assert.fail();
		}
		
	}
	
}
