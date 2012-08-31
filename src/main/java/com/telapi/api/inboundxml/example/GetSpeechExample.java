package com.telapi.api.inboundxml.example;

import com.telapi.api.inboundxml.elements.GetSpeech;
import com.telapi.api.inboundxml.elements.Response;

public class GetSpeechExample {
	
	public static void main(String[] args) {
		
		String inboundXml = Response.create()
			.getSpeech(
					GetSpeech.createGetSpeech("http://example.com/grammarfile", "http://example.com/action")
						.say("Speak and we will interpret what you say!")
					)
			.createXml();
		System.out.println(inboundXml);
		
	}
	
}
