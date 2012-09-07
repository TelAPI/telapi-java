package com.telapi.api;

import org.junit.Test;

import com.telapi.api.domain.Recording;
import com.telapi.api.domain.Transcription;
import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.domain.enums.TranscriptionStatus;
import com.telapi.api.domain.enums.TranscriptionType;
import com.telapi.api.domain.list.TranscriptionList;
import com.telapi.api.exceptions.TelapiException;

public class TranscriptionTest extends BaseTelapiTest {

	@Test
	public void testTranscribeAudio() throws TelapiException {
		Transcription tr = connector.transcribeAudioUrl(testParameters.getMp3Url(), "callbackurl.com", HttpMethod.GET, TranscriptionType.AUTO);
		String tt = connector.viewTranscriptionText(tr.getSid());
		System.out.println(tt);
	}
	
	@Test
	public void testListTranscriptions() throws TelapiException {
		TranscriptionList list = connector.listTranscriptions(0L, 10L, TranscriptionStatus.COMPLETED);
		for (Transcription t : list) {
			System.out.println(t.getSid());
		}
	}
	
	@Test
	public void testViewTranscription() throws TelapiException {
		TranscriptionList list = connector.listTranscriptions(null, null, null);
		Transcription t = list.iterator().next();
		connector.viewTranscription(t.getSid());
	}
	
	@Test
	public void testViewTranscriptionText() throws TelapiException {
		TranscriptionList list = connector.listTranscriptions(null, null, null);
		Transcription t = list.iterator().next();
		String transcription = connector.viewTranscriptionText(t.getSid());
		System.out.println(transcription);
	}
	
	@Test
	public void testTranscribeRecording() throws TelapiException {
		Recording r = connector.listRecordings(null, null, null, null).iterator().next();
		connector.transcribeRecording(r.getSid(), "transcribecallback.com", HttpMethod.GET, TranscriptionType.AUTO);
	}
	
}
