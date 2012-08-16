package com.telapi.api;

import org.junit.Assert;
import org.junit.Test;

import com.telapi.api.domain.Call;
import com.telapi.api.domain.enums.AudioDirection;
import com.telapi.api.domain.enums.CallInterruptStatus;
import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.domain.enums.Legs;
import com.telapi.api.domain.list.CallList;
import com.telapi.api.restproxies.CallProxy;

public class CallTest extends BaseTelapiTest<CallProxy>{
	
	public CallTest() {
		super(CallProxy.class);
	}

	@Test
	public void testListCalls() {
		proxy.listCalls(conf.getSid(), null, null, null, null, null, 0L, 5L).getEntity();
	}
	
	@Test
	public void makeCall() {
		Call call = proxy.makeCall(conf.getSid(), testParameters.getPhone1(), testParameters.getPhone2(), "http://www.telapi.com/ivr/welcome/call", null, null, null, null, null, null, null, 15L, null).getEntity();
		Assert.assertNotNull(call);
		Call receivedCall = proxy.viewCall(conf.getSid(), call.getSid()).getEntity();
		
		Assert.assertEquals(call.getSid(), receivedCall.getSid());
		
		//proxy.hangupCall(conf.getSid(), call.getSid(), CallInterruptStatus.COMPLETED).getEntity();
		
	}
	
	@Test
	public void hangUpAll() {
		CallList list = proxy.listCalls(conf.getSid(), null, null, null, null, null, null, null).getEntity();
		for (Call c : list) {
			proxy.hangupCall(c.getAccountSid(), c.getSid(), CallInterruptStatus.COMPLETED).getEntity();
		}
	}
	
	@Test
	public void testInterruptCall() {
		Call call = proxy.makeCall(conf.getSid(), testParameters.getPhone1(), testParameters.getPhone2(), "http://www.telapi.com/ivr/welcome/call", null, null, null, null, null, null, null, 15L, null).getEntity();
		proxy.interruptLiveCall(conf.getSid(), call.getSid(), "http://www.telapi.com/ivr/welcome/call", HttpMethod.GET, CallInterruptStatus.CANCELED).getEntity();
		proxy.hangupCall(conf.getSid(), call.getSid(), CallInterruptStatus.COMPLETED).getEntity();
	}
	
	@Test
	public void testSendDigits() {
		Call call = proxy.makeCall(conf.getSid(), testParameters.getPhone1(), testParameters.getPhone2(), "http://www.telapi.com/ivr/welcome/call", null, null, null, null, null, null, null, 15L, null).getEntity();
		proxy.sendDigits(conf.getSid(), call.getSid(), "123123wwww123", Legs.BOTH).getEntity();
		proxy.hangupCall(conf.getSid(), call.getSid(), CallInterruptStatus.COMPLETED).getEntity();	
	}
	
	@Test
	public void testPlaySound() {
		Call call = proxy.makeCall(conf.getSid(), testParameters.getPhone1(), testParameters.getPhone2(), "http://www.telapi.com/ivr/welcome/call", null, null, null, null, null, null, null, 15L, null).getEntity();
		
		proxy.playAudio(conf.getSid(), call.getSid(), "http://www.freeinfosociety.com/media/sounds/198.mp3", null, Legs.BOTH, false, true).getEntity();
		proxy.hangupCall(conf.getSid(), call.getSid(), CallInterruptStatus.COMPLETED).getEntity();
	}
	
	@Test
	public void testVoiceEffects() {
		Call call = proxy.makeCall(conf.getSid(), testParameters.getPhone1(), testParameters.getPhone2(), "http://www.telapi.com/ivr/welcome/call", null, null, null, null, null, null, null, 15L, null).getEntity();
		proxy.voiceEffects(conf.getSid(), call.getSid(), AudioDirection.OUT, 0.7, 2L, 1L, 0.9).getEntity();
		proxy.hangupCall(conf.getSid(), call.getSid(), CallInterruptStatus.COMPLETED).getEntity();
	}
	
	@Test
	public void testRecordCalls() {
		Call call = proxy.makeCall(conf.getSid(), testParameters.getPhone1(), testParameters.getPhone2(), "http://www.telapi.com/ivr/welcome/call", null, null, null, null, null, null, null, 15L, null).getEntity();
		proxy.recordCall(conf.getSid(), call.getSid(), true, 100L, null).getEntity();
		proxy.hangupCall(conf.getSid(), call.getSid(), CallInterruptStatus.COMPLETED).getEntity();
	}
}
