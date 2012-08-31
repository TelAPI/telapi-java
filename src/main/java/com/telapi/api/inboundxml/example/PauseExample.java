package com.telapi.api.inboundxml.example;

import com.telapi.api.inboundxml.elements.Response;

public class PauseExample {
	
	public static void main(String[] args) {
		
		String inboundXml = Response.create()
			.say("Hello.")
			.pause(5L)
			.say("Are you still there?")
			.createXml();
		System.out.println(inboundXml);
		
	}
	
}
