package com.telapi.api.inboundxml.example;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.inboundxml.elements.Dial;
import com.telapi.api.inboundxml.elements.Response;
import com.telapi.api.inboundxml.parameters.DialParameters;

public class DialExample {
	
	public static void main(String[] args) {
		DialParameters params = new DialParameters();
		params.setNumber("(555) 724-2212");
		params.setAction("http://liveoutput.com/telapi-inboundxml-dial-sample");
		params.setMethod(HttpMethod.GET);
		String inboundXml = Response.create()
			.dial(Dial.createDial(params)
					)
			.createXml();
		System.out.println(inboundXml);
		
	}
	
}
