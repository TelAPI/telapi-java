package com.telapi.api.inboundxml.example;

import com.telapi.api.inboundxml.elements.Response;

public class PlayExample {
	
	public static void main(String[] args) {
		
		String inboundXml = Response.create()
			.play(3L, "http://example.com/hello.mp3")
			.createXml();
		System.out.println(inboundXml);
		
	}
	
}
