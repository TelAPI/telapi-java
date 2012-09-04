package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.IncomingPhoneNumber;
import com.telapi.api.exceptions.TelapiException;

public class ViewIncomingPhoneNumberExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("ACbf75172498784edc98406f494ec7abec");
		conf.setAuthToken("11e457ff63174f3e94bd6cb9b7812021");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			IncomingPhoneNumber incomingPhoneNumber = conn.viewIncomingPhoneNumber("{IncomingPhoneNumberSid}");
			System.out.println(incomingPhoneNumber.getSid());
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
