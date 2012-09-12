package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.SmsMessage;
import com.telapi.api.exceptions.TelapiException;

public class SendSmsExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			SmsMessage smsMessage = conn
					.sendSmsMessage(
							"(XXX) XXX-XXXX",
							"(XXX) XXX-XXXX",
							"This is an SMS message sent from the TelAPI Java wrapper! Easy as 1, 2, 3!",
							null);
			System.out.println(smsMessage.getSid());
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
