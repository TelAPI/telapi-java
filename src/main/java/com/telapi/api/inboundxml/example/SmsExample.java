package com.telapi.api.inboundxml.example;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.inboundxml.elements.Response;

public class SmsExample {
	
	public static void main(String[] args) {
		
		String inboundXml = Response.create()
			.sms("Test message sent from TelAPI!", 
					"(555) 555-5552", 
					"(555) 555-5551", 
					"http://liveoutput.com/telapi-test-sms-action", 
					HttpMethod.POST, 
					"http://liveoutput.com/telapi-test-status-callback")
			.createXml();
		System.out.println(inboundXml);
		
	}
	
}
