package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.SmsMessage;
import com.telapi.api.exceptions.TelapiException;

public class SendSmsExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("ACbf75172498784edc98406f494ec7abec");
		conf.setAuthToken("11e457ff63174f3e94bd6cb9b7812021");
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
