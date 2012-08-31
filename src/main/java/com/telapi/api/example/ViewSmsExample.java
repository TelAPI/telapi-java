package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.SmsMessage;
import com.telapi.api.exceptions.TelapiException;

public class ViewSmsExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("ACbf75172498784edc98406f494ec7abec");
		conf.setAuthToken("11e457ff63174f3e94bd6cb9b7812021");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			SmsMessage smsMessage = conn.viewSmsMessage("your_sms_message_sid");
			System.out.println(smsMessage.getSid());
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
