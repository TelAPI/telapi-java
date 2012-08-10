package com.telapi.api;

import org.junit.Before;
import org.junit.Test;

import com.telapi.api.domain.Recording;
import com.telapi.api.domain.Transcription;
import com.telapi.api.domain.enums.TranscriptionType;
import com.telapi.api.domain.list.TranscriptionList;
import com.telapi.api.restproxies.RecordingProxy;
import com.telapi.api.restproxies.TranscriptionProxy;

public class TranscriptionTest extends BaseTelapiTest<TranscriptionProxy>{
	
	RecordingProxy rProxy;
	
	public TranscriptionTest() {
		super(TranscriptionProxy.class);
	}
	
	@Before
	public void initRecordingProxy(){
		rProxy = conn.createProxy(RecordingProxy.class);
	}

	@Test
	public void testTranscribeAudio() {
		Transcription tr = proxy.transcribeAudioUrl(conf.getSid(), testParameters.getMp3Url(), null, null, TranscriptionType.AUTO).getEntity();
		String tt = proxy.viewTranscriptionText(conf.getSid(), tr.getSid()).getEntity();
		System.out.println(tt);
	}
	
	@Test
	public void testListTranscriptions() {
		String s = proxy.listTranscriptionsString(conf.getSid(), null, null).getEntity();
		System.out.println(s);
		TranscriptionList list = proxy.listTranscriptions(conf.getSid(), null, null).getEntity();
		for (Transcription t : list) {
			System.out.println(t.getSid());
		}
	}
	
	@Test
	public void testViewTranscription() {
		TranscriptionList list = proxy.listTranscriptions(conf.getSid(), null, null).getEntity();
		Transcription t = list.iterator().next();
		proxy.viewTranscription(conf.getSid(), t.getSid()).getEntity();
	}
	
	@Test
	public void testViewTranscriptionText() {
		TranscriptionList list = proxy.listTranscriptions(conf.getSid(), null, null).getEntity();
		Transcription t = list.iterator().next();
		String transcription = proxy.viewTranscriptionText(conf.getSid(), t.getSid()).getEntity();
		System.out.println(transcription);
	}
	
	@Test
	public void testTranscribeRecording() {
		Recording r = rProxy.listRecordings(conf.getSid(), null, null, null, null).getEntity().iterator().next();
		proxy.transcribeRecording(conf.getSid(), r.getSid(), null, null, TranscriptionType.AUTO).getEntity();
	}
	
}
