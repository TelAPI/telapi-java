package com.telapi.api;

import org.jboss.resteasy.client.ClientResponse;
import org.junit.Before;
import org.junit.Test;

import com.telapi.api.domain.Call;
import com.telapi.api.domain.Recording;
import com.telapi.api.domain.list.RecordingList;
import com.telapi.api.restproxies.CallProxy;
import com.telapi.api.restproxies.RecordingProxy;

public class RecordingsTest extends BaseTelapiTest<RecordingProxy>{

	public RecordingsTest() {
		super(RecordingProxy.class);
	}

	@Before
	public void createCallProxy(){
		callProxy = conn.createProxy(CallProxy.class);
	}
	
	private CallProxy callProxy;
	
	@Test
	public void testListRecordings(){
		RecordingList list = proxy.listRecordings(conf.getSid(), null, null, null, null).getEntity();
		for(Recording r : list) {
			System.out.println(r.getCallSid() + " " + r.getSid());
		}
	}
	
	@Test
	public void testListCallRecordings(){
		Call c = callProxy.listCalls(conf.getSid(), null, null, null, null, null, null, null).getEntity().iterator().next();
		RecordingList list = proxy.listCallRecordings(conf.getSid(), c.getSid(), null, null, null, null).getEntity();
		
		for(Recording r : list) {
			System.out.println(r.getCallSid() + " " + r.getSid());
		}
	}
	
	@Test
	public void testViewRecording(){
		RecordingList list = proxy.listRecordings(conf.getSid(), null, null, null, null).getEntity();
		Recording r = list.iterator().next();
		proxy.viewRecording(conf.getSid(), r.getSid());
	}
	
	@Test
	public void testGetRecordingUrl(){
		RecordingList list = proxy.listRecordings(conf.getSid(), null, null, null, null).getEntity();
		Recording r = list.iterator().next();
		ClientResponse<String> response = proxy.getRecording(conf.getSid(), r.getSid());
		String url = response.getLocation().getHref();
		response.getEntity();
		System.out.println(url);
	}
}