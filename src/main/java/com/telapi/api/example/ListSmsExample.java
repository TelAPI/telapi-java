package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.SmsMessage;
import com.telapi.api.domain.list.SmsMessageList;
import com.telapi.api.exceptions.TelapiException;

public class ListSmsExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			SmsMessageList smsMessageList = conn.listSmsMessages();
			for(SmsMessage smsMessage : smsMessageList) {
				System.out.println(smsMessage.getSid());
			}
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
