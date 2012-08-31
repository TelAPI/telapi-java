package com.telapi.api.inboundxml.example;

import com.telapi.api.inboundxml.elements.Dial;
import com.telapi.api.inboundxml.elements.Response;
import com.telapi.api.inboundxml.parameters.ConferenceParameters;

public class ConferenceExample {
	
	public static void main(String[] args) {
		ConferenceParameters params = new ConferenceParameters();
		params.setConferenceName("TelAPIExampleChat");
		params.setStartConferenceOnEnter(true);
		params.setCallbackUrl("http://liveoutput.com/telapi-inboundxml-callback-action");
		params.setHangupOnStar(true);
		params.setMaxParticipants(5L);
		
		String inboundXml = Response.create()
			.dial(
					Dial.createDial()
					.conference(params)
			)
			.createXml();
		System.out.println(inboundXml);
		
	}
	
}
