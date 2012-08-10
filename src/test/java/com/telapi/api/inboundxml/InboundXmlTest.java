package com.telapi.api.inboundxml;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.inboundxml.elements.Conference;
import com.telapi.api.inboundxml.elements.Dial;
import com.telapi.api.inboundxml.elements.Gather;
import com.telapi.api.inboundxml.elements.Hangup;
import com.telapi.api.inboundxml.elements.Number;
import com.telapi.api.inboundxml.elements.Pause;
import com.telapi.api.inboundxml.elements.Play;
import com.telapi.api.inboundxml.elements.Record;
import com.telapi.api.inboundxml.elements.Redirect;
import com.telapi.api.inboundxml.elements.Reject;
import com.telapi.api.inboundxml.elements.Response;
import com.telapi.api.inboundxml.elements.Say;
import com.telapi.api.inboundxml.elements.Sip;
import com.telapi.api.inboundxml.elements.Sms;
import com.telapi.api.inboundxml.elements.enums.RejectReason;
import com.telapi.api.inboundxml.elements.enums.Voice;
import com.thoughtworks.xstream.XStream;

public class InboundXmlTest {
	public static void main(String[] args) {
		XStream xstream = new XStream();
		xstream.processAnnotations(new Class[] { Response.class, Record.class,
				Play.class, Say.class, Number.class, Dial.class,
				Conference.class, Sip.class, Hangup.class, Redirect.class,
				Reject.class, Gather.class, Sms.class, Pause.class });
		Response r = Response.create().say("Hello there!", Voice.MAN, 3L)
				.play(10L, "lala.mp3")
				.say("ohayo!", Voice.WOMAN, null)
				.dial(Dial.createDial()
						.number("123", "###", null, HttpMethod.POST)
						.conference("johnny")
						.sip("sip@sip.com", "123", null, null))
				.hangup()
				.redirect("www.google.com", HttpMethod.GET)
				.record("wheee")
				.reject(RejectReason.BUSY)
				.sms("sending", "receivingNumber", "incomingNumber")
				.pause()
				.gather(Gather.createGather("return.com")
						.pause(12L)
						.play(12L, "mp3.mp3")
						.say("the end, my friend", Voice.MAN, null));
		
		System.out.println(xstream.toXML(r));
	}
}
