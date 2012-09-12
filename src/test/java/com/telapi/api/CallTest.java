package com.telapi.api;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.telapi.api.domain.Call;
import com.telapi.api.domain.enums.AudioDirection;
import com.telapi.api.domain.enums.CallStatus;
import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.domain.enums.Legs;
import com.telapi.api.domain.list.CallList;
import com.telapi.api.exceptions.TelapiException;
import com.telapi.api.requests.CallRequest;

public class CallTest extends BaseTelapiTest{

	private CallRequest createRequest(){
		CallRequest request = new CallRequest();
		request.setTo(testParameters.getPhone1());
		request.setFrom(testParameters.getPhone2());
		request.setUrl("http://www.telapi.com/ivr/welcome/call");
		request.setTimeout(15L);
		return request;
	}
	
	@Test
	public void testListCalls() throws TelapiException {
		connector.listCalls("1", "1", CallStatus.COMPLETED, new Date(0L), new Date(), 0L, 5L);
	}
	
	@Test
	public void testViewCall() throws TelapiException {
		CallList calls = connector.listCalls(null, null, null, null, null, 0L, 5L);
		connector.viewCall(calls.iterator().next().getSid());
	}
	
	@Test
	public void makeCall() throws TelapiException {
		Call call = connector.makeCall(testParameters.getPhone1(), testParameters.getPhone2(), "http://www.telapi.com/ivr/welcome/call", HttpMethod.POST, 
				"fallbackurl.com", HttpMethod.GET, "statusCallback.com", HttpMethod.POST, "heartbeat.com", HttpMethod.GET, testParameters.getPhone2(), "123", 15L, false, false, "recording.com", HttpMethod.POST,
				true, "transcribe.com", HttpMethod.GET);
		Assert.assertNotNull(call);
		Call receivedCall = connector.viewCall(call.getSid());
		
		Assert.assertEquals(call.getSid(), receivedCall.getSid());		
		connector.hangUpCall(call.getSid());
		
	}
	
	@Test
	public void hangUpAll() throws TelapiException {
		CallList list = connector.listCalls(null, null, null, null, null, null, null);
		for (Call c : list) {
			connector.hangUpCall(c.getSid());
		}
	}
	
	@Test
	public void testSendDigits() throws TelapiException {
		
		Call call = connector.makeCall(createRequest());
		connector.sendDigits(call.getSid(), "123123wwww123", Legs.BOTH);
		connector.hangUpCall(call.getSid());
	}
	
	@Test
	public void testPlaySound() throws TelapiException {
		Call call = connector.makeCall(createRequest());
		connector.playAudioToCall(call.getSid(), "http://www.freeinfosociety.com/media/sounds/198.mp3", 15L, Legs.BOTH, false, true);
		connector.hangUpCall(call.getSid());
	}
	
	@Test
	public void testVoiceEffects() throws TelapiException {
		Call call = connector.makeCall(createRequest());
		connector.voiceEffects(call.getSid(), AudioDirection.OUT, 0.7, 2L, 1L, 0.9);
		connector.hangUpCall(call.getSid());
	}
	
	@Test
	public void testRecordCalls() throws TelapiException {
		Call call = connector.makeCall(createRequest());
		connector.recordCall(call.getSid(), true, 100L, "callback.com");
		connector.hangUpCall(call.getSid());
	}
}
