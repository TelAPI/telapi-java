package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.IncomingPhoneNumber;
import com.telapi.api.exceptions.TelapiException;

public class ViewIncomingPhoneNumberExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			IncomingPhoneNumber incomingPhoneNumber = conn.viewIncomingPhoneNumber("{IncomingPhoneNumberSid}");
			System.out.println(incomingPhoneNumber.getSid());
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
