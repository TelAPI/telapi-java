package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.IncomingPhoneNumber;
import com.telapi.api.exceptions.TelapiException;

public class AddOrDeleteIncomingPhoneNumberExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
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
