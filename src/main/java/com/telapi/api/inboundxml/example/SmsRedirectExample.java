package com.telapi.api.inboundxml.example;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.inboundxml.elements.Response;

public class SmsRedirectExample {
	
	public static void main(String[] args) {
		
		String inboundXml = Response.create()
			.sms("You will now be redirected.", 
					"(555) 555-5552", 
					"(555) 555-5551")
			.redirect("http://example.com/rest.xml", HttpMethod.POST)
			.sms("You will never receive this message.", 
					"(555) 555-5552", 
					"(555) 555-5551")
			.createXml();
		System.out.println(inboundXml);
		
	}
	
}
