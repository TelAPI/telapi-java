package com.telapi.api.inboundxml.example;

import com.telapi.api.inboundxml.elements.Response;
import com.telapi.api.inboundxml.elements.enums.RejectReason;

public class RejectExample {
	
	public static void main(String[] args) {
		
		String inboundXml = Response.create()
			.reject(RejectReason.BUSY)
			.createXml();
		System.out.println(inboundXml);
		
	}
	
}
