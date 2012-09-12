package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.IncomingPhoneNumber;
import com.telapi.api.exceptions.TelapiException;
import com.telapi.api.requests.IncomingPhoneNumberRequest;

public class UpdateIncomingPhoneNumberExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		IncomingPhoneNumberRequest ipnRequest = new IncomingPhoneNumberRequest();
		
		//the sid of the incoming phone number to be edited
		ipnRequest.setIncomingPhoneNumberSid("{IncomingPhoneNumberSid}");
		ipnRequest.setVoiceUrl("{fully_qualified_url}");
		try {
			IncomingPhoneNumber incomingPhoneNumber = conn.updateIncomingPhoneNumber(ipnRequest);
			System.out.println(incomingPhoneNumber.getSid());
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
