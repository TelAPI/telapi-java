package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.IncomingPhoneNumber;
import com.telapi.api.domain.list.IncomingPhoneNumberList;
import com.telapi.api.exceptions.TelapiException;

public class ListIncomingPhoneNumbersExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			IncomingPhoneNumberList incomingPhoneNumberList = conn.listIncomingPhoneNumbers();
			for(IncomingPhoneNumber incomingPhoneNumber : incomingPhoneNumberList) {
				System.out.println(incomingPhoneNumber.getSid());
			}
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
