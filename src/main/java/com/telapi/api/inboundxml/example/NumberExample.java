package com.telapi.api.inboundxml.example;

import com.telapi.api.inboundxml.elements.Dial;
import com.telapi.api.inboundxml.elements.Response;

public class NumberExample {
	
	public static void main(String[] args) {
		
		String inboundXml = Response.create()
			.dial(Dial.createDial().
					number("(555) 555-5555", "ww12w3221", null, null)
					)
			.createXml();
		System.out.println(inboundXml);
		
	}
	
}
