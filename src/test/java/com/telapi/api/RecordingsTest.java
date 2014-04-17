package com.telapi.api;

import java.util.Date;

import org.junit.Test;

import com.telapi.api.domain.Call;
import com.telapi.api.domain.Recording;
import com.telapi.api.domain.list.RecordingList;
import com.telapi.api.exceptions.TelapiException;

public class RecordingsTest extends BaseTelapiTest {

	@Test
	public void testListRecordings() throws TelapiException {
		RecordingList list = connector.listRecordings(new Date(0), new Date(), 0L, 10L);
		for(Recording r : list) {
			System.out.println(r.getCallSid() + " " + r.getSid());
		}
	}
	
	@Test
	public void testListCallRecordings() throws TelapiException {
		Call c = connector.listCalls(null, null, null, null, null, null, null, null).iterator().next();
		RecordingList list = connector.listCallRecordings(c.getSid(), new Date(0), new Date(), 0L, 10L);
		
		for(Recording r : list) {
			System.out.println(r.getCallSid() + " " + r.getSid());
		}
	}
	
	@Test
	public void testViewRecording() throws TelapiException {
		RecordingList list = connector.listRecordings(null, null, null, null);
		Recording r = list.iterator().next();
		connector.viewRecording(r.getSid());
	}
	
	@Test
	public void testGetRecordingUrl() throws TelapiException {
		RecordingList list = connector.listRecordings(null, null, null, null);
		Recording r = list.iterator().next();
		String url = connector.getRecordingUrl(r.getSid());
		System.out.println(url);
	}
}
