package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.Recording;
import com.telapi.api.domain.list.RecordingList;
import com.telapi.api.exceptions.TelapiException;

public class ListRecordingsExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			RecordingList recordingList = conn.listRecordings();
			for(Recording recording : recordingList) {
				System.out.println(recording.getSid());
			}
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
