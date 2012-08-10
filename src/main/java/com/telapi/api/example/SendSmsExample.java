package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.PropertiesFileTelapiConfiguration;
import com.telapi.api.exceptions.TelapiException;

public class SendSmsExample {

	public static void main(String[] args) {
		PropertiesFileTelapiConfiguration conf = new PropertiesFileTelapiConfiguration("telapi.properties");
		TelapiConnector conn = new TelapiConnector(conf);
		try {
			conn.sendSmsMessage("+1 224-632-1739", "+1 240-844-6005", "test sms", null);
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
