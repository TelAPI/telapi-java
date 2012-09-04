package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.IncomingPhoneNumber;
import com.telapi.api.exceptions.TelapiException;

public class AddOrDeleteIncomingPhoneNumberExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("ACbf75172498784edc98406f494ec7abec");
		conf.setAuthToken("11e457ff63174f3e94bd6cb9b7812021");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			IncomingPhoneNumber incomingPhoneNumber = conn.addIncomingPhoneNumber("{phone_number}", "{area_code}");
			String incomingPhoneNumberSid = incomingPhoneNumber.getSid();
			
			IncomingPhoneNumber deletedNumber = conn.deleteIncomingPhoneNumber(incomingPhoneNumberSid);
			System.out.println(deletedNumber.getSid());
			
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
