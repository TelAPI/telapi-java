package com.telapi.api.inboundxml;

import junit.framework.Assert;

import org.junit.Test;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.inboundxml.elements.Dial;
import com.telapi.api.inboundxml.elements.Gather;
import com.telapi.api.inboundxml.elements.Response;
import com.telapi.api.inboundxml.elements.enums.RejectReason;
import com.telapi.api.inboundxml.elements.enums.Voice;

public class InboundXmlTest {
	
	@Test
	public void testCreateXml(){

		Response r = Response.create().say("Hello world!", Voice.MAN, 3L)
				.play(10L, "lala.mp3")
				.say("ohayo!", Voice.WOMAN, null)
				.dial(Dial.createDial("456")
						.number("123", "###", null, HttpMethod.POST)
						.conference("my_conference")
						.sip("sip@sip.com", "123", null, null))
				.hangup()
				.redirect("www.google.com", HttpMethod.GET)
				.record("action")
				.reject(RejectReason.BUSY)
				.sms("sending", "receivingNumber", "incomingNumber")
				.pause()
				.gather(Gather.createGather("returnaddress.com")
						.pause(12L)
						.play(12L, "mp3.mp3")
						.say("Goodbye world!", Voice.MAN, null));
		String xml = r.createXml();
		Assert.assertNotNull(xml);
		System.out.println(xml);
	}
}
