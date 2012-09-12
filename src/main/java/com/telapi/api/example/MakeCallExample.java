package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.Call;
import com.telapi.api.exceptions.TelapiException;
import com.telapi.api.requests.CallRequest;

public class MakeCallExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			CallRequest callRequest = new CallRequest();
			callRequest.setFrom("(XXX) XXX-XXXX");
			callRequest.setTo("(XXX) XXX-XXXX");
			callRequest.setUrl("http://liveoutput.com/createnewcall");
			Call call = conn.makeCall(callRequest);
			System.out.println(call.getSid());
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
