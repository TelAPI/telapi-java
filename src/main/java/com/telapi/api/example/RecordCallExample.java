package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.list.RecordingList;
import com.telapi.api.exceptions.TelapiException;

public class RecordCallExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			RecordingList list = conn.recordCall("{CallSid}", true, null, null);
			System.out.println(list.getPagesize());
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
