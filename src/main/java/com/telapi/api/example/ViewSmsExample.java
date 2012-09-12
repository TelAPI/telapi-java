package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.SmsMessage;
import com.telapi.api.exceptions.TelapiException;

public class ViewSmsExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			SmsMessage smsMessage = conn.viewSmsMessage("{SmsMessageSid}");
			System.out.println(smsMessage.getSid());
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
