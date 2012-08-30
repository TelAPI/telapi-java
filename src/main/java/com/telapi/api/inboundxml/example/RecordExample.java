package com.telapi.api.inboundxml.example;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.inboundxml.elements.Response;
import com.telapi.api.inboundxml.elements.enums.Voice;
import com.telapi.api.inboundxml.parameters.RecordParameters;

public class RecordExample {
	
	public static void main(String[] args) {

		RecordParameters params = new RecordParameters("http://liveoutput.com/telapi-telml-recording-action-example");
		params.setMethod(HttpMethod.POST);
		
		String inboundXml = Response.create()
			.say("Please state your name.", Voice.MAN, 3L)
			.record(params)
			.createXml();
		
		System.out.println(inboundXml);

	}
	
}
