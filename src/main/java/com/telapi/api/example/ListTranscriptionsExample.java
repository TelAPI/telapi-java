package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.Transcription;
import com.telapi.api.domain.list.TranscriptionList;
import com.telapi.api.exceptions.TelapiException;

public class ListTranscriptionsExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			TranscriptionList transcriptionList = conn.listTranscriptions();
			for(Transcription transcription : transcriptionList) {
				System.out.println(transcription.getSid());
			}
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
