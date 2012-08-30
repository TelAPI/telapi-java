package com.telapi.api.inboundxml.example;

import com.telapi.api.inboundxml.elements.Response;
import com.telapi.api.inboundxml.elements.enums.Voice;

public class SayExample {
	
	public static void main(String[] args) {

		Response.create()
			.say("Hello.", Voice.MAN, 3L)
			.say("Hello, My name is Jane", Voice.WOMAN, null)
			.say("Now I will not stop talking.", null, 0L)
			.createXml();
				
	}
	
}
