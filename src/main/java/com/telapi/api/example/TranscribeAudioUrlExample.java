package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.Transcription;
import com.telapi.api.domain.enums.TranscriptionType;
import com.telapi.api.exceptions.TelapiException;

public class TranscribeAudioUrlExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			Transcription transcription = conn.transcribeRecording("{RecordingSid}", "http://liveoutput.com/transcribecallback", null, TranscriptionType.GOLD);
			System.out.println(transcription.getSid());
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
