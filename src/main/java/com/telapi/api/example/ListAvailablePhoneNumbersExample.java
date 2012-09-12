package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.AvailablePhoneNumber;
import com.telapi.api.domain.list.AvailablePhoneNumberList;
import com.telapi.api.exceptions.TelapiException;

public class ListAvailablePhoneNumbersExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		
		try {
			AvailablePhoneNumberList availablePhoneNumbers = conn.listAvailablePhoneNumbers("US", null, null, "Local", null, null, null);
			for (AvailablePhoneNumber availablePhoneNumber : availablePhoneNumbers) {
				System.out.println(availablePhoneNumber.getPhoneNumber());
			}
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
